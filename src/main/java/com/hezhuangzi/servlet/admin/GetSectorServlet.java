package com.hezhuangzi.servlet.admin;

import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.ClinicSector;
import com.hezhuangzi.entity.ClinicWorker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetSectorServlet", value = "/getsector")
public class GetSectorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicDao dao = new ClinicDao();
        try {
            List<ClinicSector> sectorList = dao.queryAllSectorInfo();
            if(sectorList != null && !sectorList.isEmpty()){
                request.setAttribute("clinicSector",sectorList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("getsector.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
