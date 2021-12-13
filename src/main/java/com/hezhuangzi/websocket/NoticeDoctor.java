package com.hezhuangzi.websocket;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.coder.ClinicWokerEncoding;
import com.hezhuangzi.coder.ClinicWorkerDecoder;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.entity.DoctorPatient;
import com.hezhuangzi.entity.PatientRegister;
import com.hezhuangzi.entity.Sectors;
import com.hezhuangzi.listener.ApplictionListener;
import com.hezhuangzi.services.clinic.DoctorService;
import org.apache.poi.util.DelayableLittleEndianOutput;
import org.apache.xmlbeans.impl.tool.CommandLine;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/noticedoctor")
public class NoticeDoctor {
    private ClinicDao dao = new ClinicDao();
    private Session session;

    //保存客户端
    private static final Set<NoticeDoctor> clientSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void start(Session session) throws IOException {
        this.session = session;
        clientSet.add(this);
        HttpSession httpSession = ApplictionListener.getSession();
        ClinicWorker worker = (ClinicWorker) httpSession.getAttribute(DoctorService.DOCTOR);
        String clinicId = worker.getClin_id();

        //发送
        List<PatientRegister> patientList = null;
        try {
            patientList = dao.getSectorPatient(clinicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //获取全局对象
        List<Sectors> attribute = (List<Sectors>) ApplictionListener.getAppContext().getAttribute(ApplictionListener.SECTOR);
        for (Sectors sectors : attribute) {
            if(sectors.getSector().equals(worker.getClin_type())){
                boolean alreadyDoctor = true;
                for (DoctorPatient doctorPatient : sectors.getDoctorPatientList()) {
                    if(doctorPatient.getDoctor().getClin_id().equals(clinicId)){
                        doctorPatient.setRegisterList(new LinkedList<>(patientList));
                        alreadyDoctor = false;
                    }
                }
                if (alreadyDoctor) {
                    List<DoctorPatient> doctorPatientList = sectors.getDoctorPatientList();
                    //添加一个医生和该医生的全部病人
                    doctorPatientList.add(new DoctorPatient(worker,new LinkedList<>(patientList)));
                    break;
                }
            }
        }
        session.getBasicRemote().sendText(JSON.toJSONString(attribute));
    }

    //收到消息，可以回传消息
    @OnMessage
    public void onMessage(String msg){
        try {
            for (NoticeDoctor doctor : clientSet) {
                synchronized (doctor){
                    System.out.println(msg);
                    doctor.session.getBasicRemote().sendText(msg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @OnClose
    public void end(){
        System.out.println("结束！");
        clientSet.remove(this);
    }

    @OnError
    public void onError(Throwable t) throws Throwable{
        System.out.println("Notice Websocket 出现错误！ ");
    }


}
