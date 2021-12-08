package com.hezhuangzi.servlet.patient;

import com.hezhuangzi.services.patient.ProgressService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CancelSubcribeServlet", value = "/cancelsubcribe")
public class CancelSubcribeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProgressService service = new ProgressService();
        service.cancelSubcribe(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
