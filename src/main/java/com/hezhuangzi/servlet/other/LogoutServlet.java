package com.hezhuangzi.servlet.other;

import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.listener.ApplictionListener;
import com.hezhuangzi.services.clinic.ClinicService;
import com.hezhuangzi.services.clinic.DoctorService;
import com.hezhuangzi.services.clinic.GuidanceService;
import com.hezhuangzi.services.patient.PatientService;
import com.hezhuangzi.util.OtherUtils;
import com.hezhuangzi.websocket.InfoDisplay;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String temp = "";
        HttpSession session = request.getSession();
        switch (type.trim()){
            case PatientService.SESSION_PATIENT:
                session.removeAttribute(PatientService.SESSION_PATIENT);
                response.sendRedirect("patientlogin.jsp");
                break;
            case DoctorService.DOCTOR:
                ClinicWorker doctor = (ClinicWorker) session.getAttribute(DoctorService.DOCTOR);
                OtherUtils.setDoctorPatientNull(doctor);
                InfoDisplay.getTypeData(InfoDisplay.INFO,ApplictionListener.getAllSectorPatient());
                session.removeAttribute(DoctorService.DOCTOR);
                response.sendRedirect("doctorlogin.jsp");
                break;
            case DoctorService.DRUG_DOCTOR:
                session.removeAttribute(DoctorService.DRUG_DOCTOR);
                response.sendRedirect("doctorlogin.jsp");
                break;
            case DoctorService.INFUSION_DOCTOR:
                session.removeAttribute(DoctorService.INFUSION_DOCTOR);
                response.sendRedirect("doctorlogin.jsp");
                break;
            case GuidanceService.GUIDANCE:
                session.removeAttribute(GuidanceService.GUIDANCE);
                response.sendRedirect("guidancelogin.jsp");
                break;
            case ClinicService.ADMIN:
                session.removeAttribute(ClinicService.ADMIN);
                response.sendRedirect("adminlogin.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
