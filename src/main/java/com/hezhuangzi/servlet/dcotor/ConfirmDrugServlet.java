package com.hezhuangzi.servlet.dcotor;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.util.OtherUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ConfirmDrugServlet", value = "/ConfirmDrugServlet")
public class ConfirmDrugServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = OtherUtils.setAndGetJSONOut(response);
        String registerId = request.getParameter("registerid");
        String inRegisterId = request.getParameter("inregisterid");
        String choose = request.getParameter("choose");
        ClinicDao dao = new ClinicDao();
        Map<String,Integer> result = new HashMap<>();
        Integer i = null;
        if(registerId.trim().equals(inRegisterId.trim())){
            try {
                if (dao.confirmDrug(registerId,inRegisterId)>0) {
                    i = 1;
                }else{
                    i = 0;
                }
            } catch (SQLException e) {
                i = 0;
                e.printStackTrace();
            }
        }else{
            i = 0;
        }
        result.put("result",i);
        out.println(JSON.toJSONString(result));

    }
}
