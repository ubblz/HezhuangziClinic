package com.hezhuangzi.servlet.patient;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.PatientInfo;
import com.hezhuangzi.services.patient.PatientService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

@WebServlet(name = "GetInfoServlet", value = "/getpatientinfo")
public class GetPatientInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService service = new PatientService();
        service.getPatientInfo(request,response);
    }
}
