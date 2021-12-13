package com.hezhuangzi.servlet.dcotor;

import com.hezhuangzi.services.clinic.DoctorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DoctorLoginServlet", value = "/doctorlogin")
public class DoctorLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorService service = new DoctorService();
        service.doctorLogin(request,response);
    }
}
