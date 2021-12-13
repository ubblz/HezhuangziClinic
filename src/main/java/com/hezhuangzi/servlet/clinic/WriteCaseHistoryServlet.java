package com.hezhuangzi.servlet.clinic;

import com.hezhuangzi.dao.ClinicDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "WriteCaseHistoryServlet", value = "/WriteCaseHistoryServlet")
public class WriteCaseHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/text;charset=utf-8");
        String regiId = request.getParameter("registerid");
        String hpi = request.getParameter("hpi");
        ClinicDao dao = new ClinicDao();
        PrintWriter out = response.getWriter();
        String msg = "";
        try {
            if(dao.writeCaseHistory(regiId,hpi)>0){
                msg = "success";
            }else{
                msg = "error";
            }
        } catch (SQLException e) {
            msg="error";
            e.printStackTrace();
        }
        out.println(msg);

    }
}
