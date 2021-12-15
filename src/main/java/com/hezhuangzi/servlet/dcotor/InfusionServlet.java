package com.hezhuangzi.servlet.dcotor;

import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.DrugsOfPres;
import com.hezhuangzi.entity.OrderDrug;
import com.hezhuangzi.entity.PatientPrescription;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InfusionServlet", value = "/infusiondoctor")
public class InfusionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicDao dao = new ClinicDao();
        List<DrugsOfPres> drugsOfPres = new ArrayList<>();
        try {
            //处方和药品列表
            List<PatientPrescription> prescriptionList = dao.queryAlreadyPayPres(1);
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
        request.getRequestDispatcher("infusiondoctor.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
