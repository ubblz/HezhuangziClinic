package com.hezhuangzi.servlet.admin;

import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.entity.DrugRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetDrugServlet", value = "/getdrug")
public class GetDrugServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicDao dao = new ClinicDao();
        try {
            List<DrugRepository> drugRepositories = dao.queryAllDrugInfo();
            if(drugRepositories != null && !drugRepositories.isEmpty()){
                request.setAttribute("drugRepository",drugRepositories);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("getdrug.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
