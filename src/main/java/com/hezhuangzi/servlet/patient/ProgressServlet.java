package com.hezhuangzi.servlet.patient;

import com.hezhuangzi.services.patient.ProgressService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProgressServlet", value = "/progress")
public class ProgressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 1. 打开页面
        * 2. 显示登陆患者的进度（预约、病历、处方）
        * 3. 分页
        * */
        ProgressService service = new ProgressService();



        request.getRequestDispatcher("progress.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
