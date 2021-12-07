package com.hezhuangzi.servlet.patient;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.MinMaxDate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@WebServlet(name = "SubcribeServlet", value = "/subcribe")
public class SubcribeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientDao dao = new PatientDao();
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

        } catch (SQLException e) {
            e.printStackTrace();
        }



        request.getRequestDispatcher("subcribe.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
