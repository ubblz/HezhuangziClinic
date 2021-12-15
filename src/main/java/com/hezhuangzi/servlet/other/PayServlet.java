package com.hezhuangzi.servlet.other;

import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.OrderDrug;
import com.hezhuangzi.entity.PatientPrescription;
import com.hezhuangzi.entity.PatientRegister;
import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PayServlet", value = "/PayServlet")
public class PayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registerId = request.getParameter("registerid");
        ClinicDao dao = new ClinicDao();
        int flag = 0;
        if(registerId != null){
            flag = 1;
            try {
                //1.  先查询挂号单信息
                double priceSum = 0.0d;
                PatientRegister patientRegister = dao.queryRegisterInfo(registerId);
                if(patientRegister != null){
                    request.setAttribute("regi",patientRegister);//存放挂号信息
                    //2. 再查询对应的处方单号
                    PatientPrescription patientPrescription = dao.queryPatientPrescription(registerId);
                    if(patientPrescription != null){
                        request.setAttribute("pres",patientPrescription); //存放处方信息
                        //3. 查询处方对应的药品
                        List<OrderDrug> orderDrugList = dao.queryPresOrederDrugs(patientPrescription.getPres_id());
                        if(!orderDrugList.isEmpty()){
                            request.setAttribute("order",orderDrugList);//存放药品列表信息
                            for (OrderDrug orderDrug : orderDrugList) {
                                priceSum += orderDrug.getDrug_price() * orderDrug.getOrder_num();
                            }
                            request.setAttribute("priceSum",priceSum);//存放总价格信息
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("flag",flag);
        request.getRequestDispatcher("pay.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
