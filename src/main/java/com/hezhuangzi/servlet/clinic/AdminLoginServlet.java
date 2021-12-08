package com.hezhuangzi.servlet.clinic;

import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.services.clinic.ClinicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/adminlogin")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicService service = new ClinicService();
        service.adminLogin(request,response);
    }
}
