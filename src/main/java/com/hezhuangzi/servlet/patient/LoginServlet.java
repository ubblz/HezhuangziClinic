package com.hezhuangzi.servlet.patient;

import com.hezhuangzi.dao.PatientDao;

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
        PatientDao dao = new PatientDao();
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
//        if (patientService.patientLogin(phone,pwd)) {
//            System.out.println("登陆成功！");
//            HttpSession session = request.getSession(true);
//            session.setAttribute("phone",phone);
//            response.sendRedirect("subscribe");
//        }else{
//            System.out.println("登陆失败！");
//
//        }
        try {
            if(dao.patientLogin(phone,pwd)){
                System.out.println("登陆成功！");
                HttpSession session = request.getSession(true);
                session.setAttribute("phone",phone);
                response.sendRedirect("patientinfo");
            }else{
                System.out.println("登陆失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
