package com.hezhuangzi.servlet.dcotor;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.util.OtherUtils;
import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ConfirmPayServlet", value = "/ConfirmPayServlet")
public class ConfirmPayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicDao dao = new ClinicDao();
        PrintWriter out = OtherUtils.setAndGetJSONOut(response);
        Map<String,Integer> result = new HashMap<>();
        String presId = request.getParameter("presid");
        try {
            if(dao.patientConfirmPay(presId) > 0){
                result.put("result",1);
            }else{
                result.put("result",2);
            }
        } catch (SQLException e) {
            result.put("result",0);
            e.printStackTrace();
        }
        out.println(JSON.toJSONString(result));
    }
}
