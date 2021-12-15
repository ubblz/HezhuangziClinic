package com.hezhuangzi.services.patient;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.PatientInfo;
import com.hezhuangzi.util.OtherUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PatientService {
    private PatientDao dao = new PatientDao();
    public static final String SESSION_PATIENT = "patientInfo";
    public void patientLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        //获取phone 和 手机号。
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        HttpSession session = request.getSession(true);
        try {
            PatientInfo patientInfo = dao.patientLogin(phone,pwd);
            if(patientInfo != null){
                //patienInfo 为登陆用户的信息
                session.setAttribute(PatientService.SESSION_PATIENT,patientInfo);
                System.out.println("登陆成功!");
                response.sendRedirect("patientinfo");
            }else{
                System.out.println("登陆失败!");
                request.getRequestDispatcher("patientlogin.jsp").forward(request,response);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void getPatientInfo(HttpServletRequest request, HttpServletResponse response) {
        /*
        * <p>编号:${user.patientId}</p>
            <p>姓名:${user.name}</p>
            <p>性别:${user.gen}</p>
            <p>年龄:${user.age}</p>
            <p>身份证:${user.icard}</p>
            <p>手机号码:${user.phone}</p>
            <p>邮箱:${user.email}</p>
        * */

        response.setContentType("application/json;charset=utf-8");
        HttpSession seesion = request.getSession(true);
        PatientInfo patientInfo =  (PatientInfo) seesion.getAttribute("patientInfo");
        try {
            PrintWriter out = response.getWriter();
            PatientInfo user = dao.getPatientInfo(patientInfo.getPati_id());
            System.out.println(user);
            Map<String,String> userInfo = new HashMap<>();
            userInfo.put("name",user.getPati_name());
            userInfo.put("gen",user.getPati_gen());
            userInfo.put("age",user.getPati_age().toString());
            userInfo.put("icard",user.getPati_icard());
            userInfo.put("email",user.getPati_email());
            out.println(JSON.toJSONString(userInfo));
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void modifyPatientInfo(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        HttpSession session = request.getSession(true);
        PatientInfo patientInfo = (PatientInfo) session.getAttribute("patientInfo");
        if(patientInfo != null){
            String name = request.getParameter("modifyname");
            String gen = request.getParameter("modifygen");
            String age = request.getParameter("modifyage");
            String icard = request.getParameter("modifyicard");
            String email = request.getParameter("modifyemail");
//            System.out.println(phone);

            Map<String,String> map = new HashMap<>();
            try {
                PrintWriter out = response.getWriter();
                int count = dao.updatePatientInfo(patientInfo.getPati_id(),name,age,gen,icard,email);
                session.setAttribute("patientInfo",dao.getPatientInfo(patientInfo.getPati_id()));
                if(count > 0){
                    map.put("status","success");
                }else{
                    map.put("status","fail");
                }
                out.println(JSON.toJSONString(map));
            } catch (SQLException | IOException e) {
                e.printStackTrace();
                map.put("status","fail");
            }
        }

//        response.setContentType("application/json");
        //获取当前用户的信息
//        HttpSession session = request.getSession(true);
//        PatientInfo patientInfo = (PatientInfo) session.getAttribute("patientInfo");
//
//        if(patientInfo != null){
//            //获取post参数
//            String name = request.getParameter("modifyname");
//            String gen = request.getParameter("modifygen");
//            String age = request.getParameter("modifyage");
//            String icard = request.getParameter("modifyicard");
//            String email = request.getParameter("modifyemail");
//
//            try {
//                //修改用户信息
//                int count = dao.updatePatientInfo(patientInfo.getPatientId(),name,age,gen,icard,email);
//
//                if(count > 0){
//                    PatientInfo modified =  dao.getPatientInfo(patientInfo.getPatientId());
//                    session.setAttribute("patientInfo",modified);
//                    //跳转
//                    response.sendRedirect("patientinfo");
//                }
//            } catch (SQLException | IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public void displayPatientInfo(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession(true);
//        PatientInfo patientInfo = (PatientInfo) session.getAttribute("patientInfo");
//        if(patientInfo != null){
////            String phone = (String) session.getAttribute("phone");
//            try {
//                String patientId = patientInfo.getPatientId();
//                PatientInfo userInfo = dao.getPatientInfo(patientId);
//                request.setAttribute("user",userInfo);
//                request.getRequestDispatcher("patientinfo.jsp").forward(request,response);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        try {
            request.getRequestDispatcher("patientinfo.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void patientRegister(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        String msg = "";
        try {
            if (dao.patientRegister(phone,pwd)>0) {
                msg = "注册成功！";
            }else{
                msg = "注册失败！";
            }
        } catch (Exception e) {
            msg = "注册失败！";
            e.printStackTrace();
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }
}
