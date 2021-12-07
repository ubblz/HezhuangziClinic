package com.hezhuangzi.servlet.patient;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.services.patient.PatientService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService service = new PatientService();
        service.successLogin(request,response);
    }
}
