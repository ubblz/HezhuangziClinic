package com.hezhuangzi.servlet.patient;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.PatientInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

@WebServlet(name = "GetInfoServlet", value = "/getinfo")
public class GetInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientDao dao = new PatientDao();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        HttpSession seesion = request.getSession();
        String phone =  (String) seesion.getAttribute("phone");
        /*
        * <p>编号:${user.patientId}</p>
            <p>姓名:${user.name}</p>
            <p>性别:${user.gen}</p>
            <p>年龄:${user.age}</p>
            <p>身份证:${user.icard}</p>
            <p>手机号码:${user.phone}</p>
            <p>邮箱:${user.email}</p>
        * */
        try {
            PatientInfo user = dao.getPatientInfo(phone);
            System.out.println(user);
            Map<String,String> userInfo = new HashMap<>();
            userInfo.put("name",user.getName());
            userInfo.put("gen",user.getGen());
            userInfo.put("age",user.getAge().toString());
            userInfo.put("icard",user.getIcard());
            userInfo.put("email",user.getEmail());
            out.println(JSON.toJSONString(userInfo));

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("");
        }
    }
}
