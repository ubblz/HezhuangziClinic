package com.hezhuangzi.servlet.dcotor;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.entity.DoctorPatient;
import com.hezhuangzi.entity.PatientInfo;
import com.hezhuangzi.entity.PatientRegister;
import com.hezhuangzi.listener.ApplictionListener;
import com.hezhuangzi.services.clinic.DoctorService;
import com.hezhuangzi.util.OtherUtils;
import com.hezhuangzi.websocket.InfoDisplay;
import com.hezhuangzi.websocket.NoticeDoctor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sound.sampled.Line;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;

@WebServlet(name = "DoctorWorkServlet", value = "/PatientingServlet")
public class PatientingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text;charset=utf-8");
        DoctorPatient doctorPatient = OtherUtils.getDoctorPatient(getServletContext(), request);
        LinkedList<PatientRegister> patientList = doctorPatient.getRegisterList();
        PatientRegister patientInfo = patientList.removeFirst();
        HttpSession session = request.getSession(true);
        ClinicWorker doctor = (ClinicWorker) session.getAttribute(DoctorService.DOCTOR);
        String clinicId = doctor.getClin_id();
        ClinicDao dao = new ClinicDao();
        PrintWriter out = response.getWriter();
        doctorPatient.setPatienting(patientInfo);//设置正在就诊
        String msg = "success";
        try {
            if(dao.registerFinish(patientInfo.getRegi_id())>0){
                System.out.println("进入就诊");
//                InfoDisplay.getTypePatientData(InfoDisplay.INFO,clinicId,patientInfo.getPati_name(),ApplictionListener.getAllSectorPatient());
                InfoDisplay.getTypeData(InfoDisplay.INFO,ApplictionListener.getAllSectorPatient());
            }else {
                msg = "error";
            }
        } catch (SQLException e) {
            msg = "error";
            e.printStackTrace();
        }
//        OtherUtils.sendDoctorPatientList(JSON.toJSONString(ApplictionListener.getAllSectorPatient()));
        out.println(msg);
    }
}
