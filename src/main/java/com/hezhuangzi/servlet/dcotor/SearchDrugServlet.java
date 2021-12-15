package com.hezhuangzi.servlet.dcotor;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.DrugRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchDrugServlet", value = "/SearchDrugServlet")
public class SearchDrugServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String drugName = request.getParameter("drugname");
        ClinicDao dao = new ClinicDao();
        Map<String,Object> result = new HashMap<>();
        PrintWriter out = response.getWriter();
        try {
            List<DrugRepository> drugRepositories = dao.searchDrugRepository(drugName);
            if(drugRepositories != null && !drugRepositories.isEmpty()){
                result.put("result",1);
                result.put("data",drugRepositories);
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
