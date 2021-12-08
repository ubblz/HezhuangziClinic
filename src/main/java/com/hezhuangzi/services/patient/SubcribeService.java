package com.hezhuangzi.services.patient;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SubcribeService {

    private PatientDao dao = new PatientDao();


    public void selectDoctor(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String date = request.getParameter("date");
        String sector = request.getParameter("sector");
        String time = request.getParameter("time");
        System.out.println(date);
        System.out.println(sector);
        System.out.println(time);
        try {
            PrintWriter out = response.getWriter();
            List doctorList = dao.selectDoctor(date,sector,time);
            Map<String,List<Map<String,String>>> doctors = new HashMap<>();
            doctors.put("doctors",(List<Map<String,String>>)doctorList);
            out.println(JSON.toJSONString(doctors));
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void displaySubcribe(HttpServletRequest request, HttpServletResponse response) {
        try {
            MinMaxDate minMaxDate = dao.getSubMinMaxDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date nowDate = new Date();
            if(minMaxDate.getMinDate().compareTo(nowDate) > 0){
                request.setAttribute("min",minMaxDate.getMinDate().toString());
                request.setAttribute("max",minMaxDate.getMaxDate().toString());
            }else{
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(nowDate);
                calendar.add(calendar.DATE,1); //把日期往后增加一天,整数  往后推,负数往前移动
                nowDate = calendar.getTime(); //这个时间就是日期往后推一天的结果
                String nowDateStr = sdf.format(nowDate);
                request.setAttribute("min",nowDateStr);
                request.setAttribute("max",minMaxDate.getMaxDate().toString());
            }

            if(nowDate.compareTo(minMaxDate.getMaxDate()) == 0 ){
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(nowDate);
                calendar.add(calendar.DATE,2); //把日期往后增加一天,整数  往后推,负数往前移动
                nowDate = calendar.getTime(); //这个时间就是日期往后推一天的结果
                String nowDateStr = sdf.format(nowDate);
                request.setAttribute("max",nowDateStr);
                request.setAttribute("min",minMaxDate.getMaxDate().toString());
            }
            request.getRequestDispatcher("subcribe.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subcribeDoctor(HttpServletRequest request, HttpServletResponse response) {
        /*
        * 1.患者当前没有其他预约，可以预约
        * 2.如果已有预约，不能预约。
        * 3.如果有爽约的，不能预约同一周的
        * 4.
        * */

        response.setContentType("application/json");
        PrintWriter out = null;
        Map<String,Integer> result = new HashMap<>();
        try {
            out = response.getWriter();
            HttpSession seesion = request.getSession();
            String arrangeId = request.getParameter("arrangeId");

            ArragneDoctor dcotor = dao.getDoctorInfo(arrangeId);
            PatientInfo patientInfo = (PatientInfo) seesion.getAttribute("patientInfo");;
            /*
            *  0 = 预约出现错误
            *  1 = 成功预约
            *  2 = 表示已有预约
            *  3 = 表示有爽约记录
            * */
            Map breakTime = dao.queryBreakTime(patientInfo.getPatientId());
            boolean alreadySubcribe = dao.queryAlreaySubcribe(patientInfo.getPatientId());
            if(alreadySubcribe){
                result.put("result",2);
            }else if(breakTime  != null){
                result = breakTime;
                result.put("result",3);
            }else{
                if(dao.addPatientSubcribe(dcotor,patientInfo)){
                    result.put("result",1) ;
                }else{
                    result.put("result",0);
                }
            }
            out.println(JSON.toJSONString(result));

        } catch (IOException | SQLException e) {
            e.printStackTrace();
            result.put("result",0);
            out.println(JSON.toJSONString(result));
        }
    }
}
