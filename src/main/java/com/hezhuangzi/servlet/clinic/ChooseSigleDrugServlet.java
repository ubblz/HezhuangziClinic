package com.hezhuangzi.servlet.clinic;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.util.OtherUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ChooseSigleDrugServlet", value = "/ChooseSigleDrugServlet")
public class ChooseSigleDrugServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = OtherUtils.setAndGetJSONOut(response);
        String regiId = request.getParameter("registerid");
        String drugId = request.getParameter("drugid");
        String chooseNum = request.getParameter("choosenum");
        Map<String,Object> result = new HashMap<>();
        ClinicDao dao = new ClinicDao();
        try {
            BigInteger order_id = dao.insertPresDrug(regiId,drugId,chooseNum);
            if (order_id != null) {
                dao.devDrugNum(drugId,chooseNum);
                result.put("result",1);
                result.put("orderid",order_id);
            }else{
                result.put("result",0);
            }
        } catch (SQLException e) {
            result.put("result",0);
            e.printStackTrace();
        }
        out.println(JSON.toJSONString(result));
    }
}
