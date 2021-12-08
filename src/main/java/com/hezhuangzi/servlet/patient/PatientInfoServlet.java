package com.hezhuangzi.servlet.patient;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.PatientInfo;
import com.hezhuangzi.services.patient.PatientService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "SubscribeServlet", value = "/patientinfo")
public class PatientInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService service = new PatientService();
        service.displayPatientInfo(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
