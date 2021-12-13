package com.hezhuangzi.servlet.dcotor;

import com.hezhuangzi.entity.DoctorPatient;
import com.hezhuangzi.listener.ApplictionListener;
import com.hezhuangzi.util.OtherUtils;
import com.hezhuangzi.websocket.InfoDisplay;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EndPatientingServlet", value = "/EndPatientingServlet")
public class EndPatientingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorPatient doctorPatient = OtherUtils.getDoctorPatient(getServletContext(), request);
        doctorPatient.setPatienting(null);
        InfoDisplay.getTypeData(InfoDisplay.INFO, ApplictionListener.getAllSectorPatient());
    }
}
