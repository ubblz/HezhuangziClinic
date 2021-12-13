package com.hezhuangzi.servlet.patient;

import com.hezhuangzi.services.patient.SubcribeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SelectDoctorServlet", value = "/querysubcribedoctor")
public class QuerySubcribeDoctorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubcribeService service = new SubcribeService();
        service.querySubcribeDoctor(request,response);
    }
}
