package com.hezhuangzi.services.clinic;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.entity.DoctorPatient;
import com.hezhuangzi.entity.PatientRegister;
import com.hezhuangzi.entity.PatientSubcribe;
import com.hezhuangzi.listener.ApplictionListener;
import com.hezhuangzi.util.OtherUtils;
import com.hezhuangzi.websocket.InfoDisplay;
import com.hezhuangzi.websocket.NoticeDoctor;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GuidanceService {
    private ClinicDao dao = new ClinicDao();
    public static  final  String GUIDANCE = "guidance";

    public void guidanceLogin(HttpServletRequest request, HttpServletResponse response) {
        String clinicId = request.getParameter("clinicid");
        String pwd = request.getParameter("pwd");
        String type = request.getParameter("guidancetype");
        try {
            ClinicWorker guidance = dao.clinicWorkerLogin(clinicId,pwd,type);
            if(guidance!=null){
                HttpSession session = request.getSession();
                session.setAttribute("guidance",guidance);
                response.sendRedirect("guidance");
            }else{
                String msg = "帐号密码错误，登陆失败！";
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("guidancelogin.jsp").forward(request,response);
            }
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    public void guidanceIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String type = ((ClinicWorker)session.getAttribute(GUIDANCE)).getClin_type();
        String sector = "";
        String guidanceType = "";
        switch (type){
            case "neikeguidan":
                guidanceType = "内科导诊";
                sector = "neike";
                break;
            case "waikeguidan":
                guidanceType = "外科导诊";
                sector = "waike";
                break;
            case "erkeguidan":
                guidanceType = "儿科导诊";
                sector = "erke";
                break;
            case "pifukeguidan":
                guidanceType = "皮肤科导诊";
                sector = "pifuke";
                break;
            case "wuguankeguidan":
                guidanceType = "五官科导诊";
                sector = "wuguanke";
                break;
        }
        request.setAttribute("guidanceType",guidanceType);

        //获取所有在排队的  get type
        try {
            List<PatientRegister> register = dao.getSectorRegister(sector);
            if(!register.isEmpty()){
                request.setAttribute("registerList",register);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("guidance.jsp").forward(request,response);
    }

    public void guidanceRegister(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        String subcribeId = request.getParameter("subcribeid");
        HttpSession session = request.getSession();
        ClinicWorker guidance = (ClinicWorker)session.getAttribute(GuidanceService.GUIDANCE);
        String clinId =guidance.getClin_id();
        String sector = chooseSector(guidance.getClin_type());
        PatientSubcribe subcribe = null;
        int result;
        try {
            subcribe = dao.guidanceGetSubcribe(subcribeId,sector);
            if(subcribe != null){//挂号成功！
                dao.releaseRegister(subcribeId, clinId);//添加一个挂号单和完成一个预约单号
                PatientRegister patientRegister = dao.getPatientRegister(subcribeId);
                //查看医生是否在线
                DoctorPatient doctorPatient = OtherUtils.toRegisterGetDoctorPatient(patientRegister);
                if(doctorPatient != null){
                    //发送给医生
                    doctorPatient.getRegisterList().addLast(patientRegister);
                    NoticeDoctor doctor = new NoticeDoctor();
                    doctor.onMessage(JSON.toJSONString(ApplictionListener.getAllSectorPatient()));

                    //发送给显示屏
                    InfoDisplay.getTypeData(InfoDisplay.INFO,ApplictionListener.getAllSectorPatient());

                }

//                DoctorPatient doctorPatient = OtherUtils.getDoctorPatient(servletContext, request);
//                NoticeDoctor doctor = new NoticeDoctor();
//                doctor.onMessage(JSON.toJSONString(doctorPatient));
                //添加完成要发送给医生和显示屏
                result = 1;
            }else{
                result = 2;
            }

        } catch (Exception e) {
            result = 0;
            e.printStackTrace();
        }
        request.setAttribute("result",result);
        response.sendRedirect("guidance");
    }

    private String chooseSector(String type){
        String sector = "";
        switch (type){
            case "neikeguidan":
                sector = "neike";
                break;
            case "waikeguidan":
                sector = "waike";
                break;
            case "erkeguidan":
                sector = "erke";
                break;
            case "pifukeguidan":
                sector = "pifuke";
                break;
            case "wuguankeguidan":
                sector = "wuguanke";
                break;
        }
        return sector;
    }

}

