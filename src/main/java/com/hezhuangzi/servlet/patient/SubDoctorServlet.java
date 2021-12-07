package com.hezhuangzi.servlet.patient;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.services.patient.SubcribeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SubDoctorServlet", value = "/subdoctor")
public class SubDoctorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //可以预约医生
        /*
        * 1. 先把发送过来的数据先查找对应的医生
        * 2. 再查找当前用户的信息
        * 3. 把信息插入到表里
        * 4. 医生的挂号数减1
        * 5.
        * */
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        HttpSession seesion = request.getSession();
        SubcribeService service = new SubcribeService();

        String arrangeId = request.getParameter("arrangeId");
        String phone = (String) seesion.getAttribute("phone");
        Map<String,Integer> result = new HashMap<>();
        if(service.addSub(arrangeId,phone)){
            result.put("result",1);
            out.println(JSON.toJSONString(result));
        }else{
            result.put("result",0);
            out.println(JSON.toJSONString(result));
        }

    }



}
