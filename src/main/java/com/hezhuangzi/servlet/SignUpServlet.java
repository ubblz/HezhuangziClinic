package com.hezhuangzi.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String phone = req.getParameter("phone");
        String pwd = req.getParameter("pwd");
//        boolean success = SignService.signUp(phone,pwd);
//        if(success){
//            out.println("注册成功！");
//        }
//        else
//        {
//            out.println("注册失败！");
//        }
    }
}
