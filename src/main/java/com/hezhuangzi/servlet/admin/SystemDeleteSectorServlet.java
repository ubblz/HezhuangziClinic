package com.hezhuangzi.servlet.admin;

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

@WebServlet(name = "SystemDeleteSectorServlet", value = "/SystemDeleteSectorServlet")
public class SystemDeleteSectorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = OtherUtils.setAndGetJSONOut(response);
        String clintype = request.getParameter("clintype");
        ClinicDao dao = new ClinicDao();
        Map<String,Integer> result = new HashMap<>();
        try {
            if (dao.systemDeleteSector(clintype)>0) {
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
