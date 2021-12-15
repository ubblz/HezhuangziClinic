package com.hezhuangzi.services.clinic;

import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.*;
import com.hezhuangzi.listener.ApplictionListener;
import com.hezhuangzi.websocket.InfoDisplay;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DoctorService {
    private ClinicDao dao = new ClinicDao();
    public static final String DOCTOR = "doctor";
    public static final String DRUG_DOCTOR = "drugdoctor";
    public static final String INFUSION_DOCTOR = "infusiondoctor";

    public void doctorLogin(HttpServletRequest request, HttpServletResponse response) {
        String clinicId = request.getParameter("clinicid");
        String pwd = request.getParameter("pwd");
        String type = request.getParameter("dcotortype");
        try {
            ClinicWorker doctor = dao.clinicWorkerLogin(clinicId,pwd,type);
            if(doctor!=null){
                HttpSession session = request.getSession(true);
                if(type.equals("drug")){
                    response.sendRedirect("drugdoctor");
                    session.setAttribute(DRUG_DOCTOR,doctor);
                }else if(type.equals("infusion")){
                    response.sendRedirect("infusiondoctor");
                    session.setAttribute(INFUSION_DOCTOR,doctor);
                }else{
                    response.sendRedirect("doctor");
                    session.setAttribute(DOCTOR,doctor);
                }
            }else{
                String msg = "帐号密码错误，登陆失败！";
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("doctorlogin.jsp").forward(request,response);
            }
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    public void doctorIndex(HttpServletRequest request, HttpServletResponse response, ServletContext application) throws ServletException, IOException {
        //获取保存医生的信息的记录
        HttpSession session = request.getSession(true);
        ClinicWorker worker = (ClinicWorker) session.getAttribute(DoctorService.DOCTOR);
        //医生的ID;
        String clinicId = worker.getClin_id();
        try {
            //获取该医生的所有病人
            List<PatientRegister> patientList = dao.getSectorPatient(clinicId);
//            //获取全局对象
//            List<Sectors> attribute = (List<Sectors>) application.getAttribute(ApplictionListener.SECTOR);
//            for (Sectors sectors : attribute) {
//                if(sectors.getSector().equals(doctorInfo.getClin_type())){
//                    List<DoctorPatient> doctorPatientList = sectors.getDoctorPatientList();
//                    //添加一个医生和该医生的全部病人
//                    doctorPatientList.add(new DoctorPatient(doctorInfo,new LinkedList<>(patientList)));
//                    break;
//                }
//            }
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
            InfoDisplay.getTypeData(InfoDisplay.INFO,ApplictionListener.getAllSectorPatient());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("doctorindex.jsp").forward(request,response);
    }
}