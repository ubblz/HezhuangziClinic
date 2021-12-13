package com.hezhuangzi.servlet.clinic;

import com.hezhuangzi.services.clinic.GuidanceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/registersubcribe")
public class RegisterSubcribeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GuidanceService service = new GuidanceService();
        service.guidanceRegister(request,response,getServletContext());
    }
}
