package com.hezhuangzi.servlet.dcotor;

import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.services.clinic.DoctorService;
import com.hezhuangzi.util.OtherUtils;
import com.hezhuangzi.websocket.InfoDisplay;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sound.sampled.Line;
import java.io.IOException;

@WebServlet(name = "CallPatientServlet", value = "/CallPatientServlet")
public class CallPatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String patientName = request.getParameter("patientname");
        InfoDisplay.getTypeData(InfoDisplay.CALL,patientName);
    }
}
