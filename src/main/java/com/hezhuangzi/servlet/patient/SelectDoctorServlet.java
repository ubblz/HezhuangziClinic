package com.hezhuangzi.servlet.patient;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.ChooseDoctor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "SelectDoctorServlet", value = "/selectdoctor")
public class SelectDoctorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientDao dao = new PatientDao();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String date = request.getParameter("date");
        String sector = request.getParameter("sector");
        String time = request.getParameter("time");
        System.out.println(date);
        System.out.println(sector);
        System.out.println(time);
        try {
//            List<ChooseDoctor> doctorList = dao.selectDoctor("2021-12-05","erke","amsubnum");
//            List<Map<String,String>> docInfo = new ArrayList<>();
//            for (ChooseDoctor chooseDoctor : doctorList) {
//                Map<String,String> temp = new HashMap<>();
//                temp.put("arrangeId",chooseDoctor.getArrangeId().toString());
//                temp.put("amsubnum",chooseDoctor.getAmsubnum().toString());
//                temp.put("pmsubnum",chooseDoctor.getPmsubnum().toString());
//                temp.put("cname",chooseDoctor.getCname());
//                temp.put("gen",chooseDoctor.getGen());
//                temp.put("age",chooseDoctor.getAge().toString());
//                temp.put("post",chooseDoctor.getPost());
//                temp.put("pic",chooseDoctor.getPic());
//                docInfo.add(temp);
//            }
//            Map<String,List<Map<String,String>>> allDate = new HashMap<>();
//            allDate.put("doctors",docInfo);
//
//            out.println(JSON.toJSONString(allDate));
            List doctorList = dao.selectDoctor("2021-12-05","erke","amsubnum");
            Map<String,List<Map<String,String>>> doctors = new HashMap<>();
            doctors.put("doctors",(List<Map<String,String>>)doctorList);
            out.println(JSON.toJSONString(doctors));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientDao dao = new PatientDao();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String date = request.getParameter("date");
        String sector = request.getParameter("sector");
        String time = request.getParameter("time");

        System.out.println(date);
        System.out.println(sector);
        System.out.println(time);
        try {
            List doctorList = dao.selectDoctor(date,sector,time);
            Map<String,List<Map<String,String>>> doctors = new HashMap<>();
            doctors.put("doctors",(List<Map<String,String>>)doctorList);
            out.println(JSON.toJSONString(doctors));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
