package com.hezhuangzi.servlet.patient;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.PatientDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/modifypatientinfo")
public class ModifyInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Map<String,String> map = new HashMap<>();
        map.put("1","2");
        out.println(JSON.toJSONString(map));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientDao dao = new PatientDao();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String phone = (String) session.getAttribute("phone");
        String name = request.getParameter("modifyname");
        String gen = request.getParameter("modifygen");
        String age = request.getParameter("modifyage");
        String icard = request.getParameter("modifyicard");
        String email = request.getParameter("modifyemail");
        System.out.println(phone);

        Map<String,String> map = new HashMap<>();
        try {
            int count = dao.updatePatientInfo(phone,name,age,gen,icard,email);
            if(count > 0){
                map.put("status","success");
            }else{
                map.put("status","fail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            map.put("status","fail");
        }
        out.println(JSON.toJSONString(map));
    }
}
