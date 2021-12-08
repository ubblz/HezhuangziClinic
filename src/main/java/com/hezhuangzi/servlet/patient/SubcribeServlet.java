package com.hezhuangzi.servlet.patient;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.MinMaxDate;
import com.hezhuangzi.services.patient.SubcribeService;

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
        SubcribeService service = new SubcribeService();
        service.displaySubcribe(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
