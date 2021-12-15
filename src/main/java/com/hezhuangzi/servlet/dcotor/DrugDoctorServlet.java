package com.hezhuangzi.servlet.dcotor;

import com.alibaba.excel.event.Order;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.DrugsOfPres;
import com.hezhuangzi.entity.OrderDrug;
import com.hezhuangzi.entity.PatientPrescription;
import com.sun.xml.bind.v2.util.CollisionCheckStack;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DrugDoctorServlet", value = "/drugdoctor")
public class DrugDoctorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicDao dao = new ClinicDao();
        List<DrugsOfPres> drugsOfPres = new ArrayList<>();
        try {
            //处方和药品列表
            List<PatientPrescription> prescriptionList = dao.queryAlreadyPayPres(0);
            if(prescriptionList != null && !prescriptionList.isEmpty()){
                for(PatientPrescription patientPrescription : prescriptionList) {
                    List<OrderDrug> orderDrugs = dao.queryPresOrederDrugs(patientPrescription.getPres_id());
                    drugsOfPres.add(new DrugsOfPres(patientPrescription,orderDrugs));
                }
                request.setAttribute("drugsOfPres",drugsOfPres);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("drugdoctor.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
