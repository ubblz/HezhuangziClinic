package com.hezhuangzi.servlet.clinic;

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

@WebServlet(name = "ChooseMethodServlet", value = "/ChooseMethodServlet")
public class ChooseMethodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = OtherUtils.setAndGetJSONOut(response);
        String regiId = request.getParameter("registerid");
        String choose = request.getParameter("choose");
        ClinicDao dao = new ClinicDao();
        Map<String,Object> result = new HashMap<>();
        try {
            if(dao.doctorChooseMethod(regiId,choose) > 0){
                result.put("result",1);
            }else{
                result.put("result",0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println(JSON.toJSONString(result));

    }
}
