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
        PatientDao dao = new PatientDao();
        HttpSession session = request.getSession();
        String phone = (String) session.getAttribute("phone");
        try {
            PatientInfo userInfo = dao.getPatientInfo(phone);
            request.setAttribute("user",userInfo);
            request.getRequestDispatcher("patientinfo.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
