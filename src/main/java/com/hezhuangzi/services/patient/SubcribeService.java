package com.hezhuangzi.services.patient;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.*;
import com.hezhuangzi.util.AmPm;
import com.hezhuangzi.util.OtherUtils;
import sun.text.resources.cldr.lg.FormatData_lg;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SubcribeService {

    private PatientDao dao = new PatientDao();


    public void querySubcribeDoctor(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");

        String date = request.getParameter("date");
        String sector = request.getParameter("sector");
        String time = request.getParameter("time");

//        System.out.println(date);
//        System.out.println(sector);
//        System.out.println(time);

        try {
            PrintWriter out = response.getWriter();
            List<ArrangeDoctor> list = dao.querySubcribeDoctor(date, sector, time);
//            System.out.println(list);
            out.println(JSON.toJSONString(list));
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

    public void subcribeDoctor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
        * 1.患者当前没有其他预约，可以预约
        * 2.如果已有预约，不能预约。
        * 3.如果有爽约的，不能预约同一周的
        * 4.
        * */
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        Map<String,Integer> result = new HashMap<>();
        out = response.getWriter();
        try {
            HttpSession seesion = request.getSession();
            String arrangeId = request.getParameter("arrangeId");
            System.out.println(arrangeId);
            String patiId = ((PatientInfo) seesion.getAttribute("patientInfo")).getPati_id();
            System.out.println(patiId);
            /*
            *  0 = 预约出现错误
            *  1 = 成功预约
            *  2 = 表示已有预约
            *  3 = 表示有爽约记录
            * */
            //先查爽约的
            /*
            * 爽约：
                1. 查询或者的预约中未完成的的最大日期和最大日期的时间段
                2. 查询出来后，对比当前的日期和时间
                3. 先对比日期，如果预约的日期大于且不等于当前日期就等于已有预约了。
                                如果小于且不等于当前日期就等于有了爽约。
                4. 如果日期对比等于同一天，则比较上午和下午时间段
                        （1）如果在当前时段就还没有爽约
                        （2）如果不在当前时段
                            1）在预约的时间段前，还没到时间段
                            2）在预约的时间段后，已经爽约
            *
            * */
            //爽约
            boolean rightSubcirbe = OtherUtils.queryBreakTimeDate(patiId);
            if(!rightSubcirbe){ //不可以预约
                System.out.println("爽约");
                result.put("result",3);
            }else{
                if(dao.queryAlreaySubcribe(patiId)){
                    System.out.println("已有预约，不能预约！");
                    result.put("result",2);
                }else if(dao.addPatientSubcribe(arrangeId,patiId) > 0){
                    System.out.println("预约成功！");
                    result.put("result",1);
                }else{
                    result.put("result",0);
                }
            }
            out.println(JSON.toJSONString(result));

        } catch (SQLException e) {
            System.out.println("出现错误");
            e.printStackTrace();
        }
    }
}
