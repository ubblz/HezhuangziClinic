package com.hezhuangzi.services.patient;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.*;
import com.hezhuangzi.util.OtherUtils;
import org.apache.poi.hssf.record.TableRecord;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgressService {
    private PatientDao dao = new PatientDao();

    public void displayProgress(HttpServletRequest request, HttpServletResponse response) {
        /*
         * 1. 打开页面
         * 2. 显示登陆患者的进度（预约、病历、处方）
         * 3. 分页
         * */

        try {
            int start = 0; //开始是0 到 偏移
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));
            }
            request.setAttribute("start",start);
            //获取当前用户信息
            HttpSession session = request.getSession();
            String patientId = ((PatientInfo)session.getAttribute("patientInfo")).getPati_id();
            //查询用户所有的subcribeId
            List<PatientSubcribe> subcribeList = dao.getPatientAllSubcribe(patientId);
            if(subcribeList.size() == 0){
                request.setAttribute("patientProgress",null);
            }else {
                //下一记录
                if (subcribeList.size() > 1 && start + 1 < subcribeList.size()) {
                    request.setAttribute("next", true);
                }
                //上一记录
                if (subcribeList.size() > 1 && start - 1 > -1) {
                    request.setAttribute("pre", true);
                }

                SubcRegiCasePres subcRegiCasePres = new SubcRegiCasePres();
                subcRegiCasePres.setPatientSubcribe(subcribeList.get(start));


                //判断取消的
                if(subcribeList.get(start).getSubc_cancel() == 0 && subcribeList.get(start).getSubc_finish() == 0 ){
                    request.setAttribute("cancel", true);
                }

                Date breakDate = subcribeList.get(start).getArra_subdate();
                String breakAmpm = subcribeList.get(start).getArra_ampm();
                if(!OtherUtils.queryBreakTimeDate(breakDate,breakAmpm)){
                    request.setAttribute("cancel",false);
                    request.setAttribute("breakTime",true);
                }

                if (subcribeList.get(start).getSubc_finish() == 1) {
                    PatientRegister register = dao.getPatientRegister(subcribeList.get(start).getSubc_id());
                    subcRegiCasePres.setPatientRegister(register);
                    if ( register.getRegi_finish() == 1) {
                        PatientCaseHistory history = dao.getPatientCaseHistory(register.getRegi_id());
                        PatientPrescription prescription = dao.getPatientPrescription(register.getRegi_id());
                        List<OrderDrug> orderDrugList = dao.getOrderDrug(prescription.getPres_id());
                        subcRegiCasePres.setPatientCaseHistory(history);
                        subcRegiCasePres.setPatientPrescription(prescription);
                        subcRegiCasePres.setOrderDrugList(orderDrugList);
                    }else{
                        subcRegiCasePres.setPatientCaseHistory(null);
                        subcRegiCasePres.setPatientPrescription(null);
                        subcRegiCasePres.setOrderDrugList(null);
                    }
                } else {
                    subcRegiCasePres.setPatientRegister(null);
                    subcRegiCasePres.setPatientCaseHistory(null);
                    subcRegiCasePres.setPatientPrescription(null);
                    subcRegiCasePres.setOrderDrugList(null);
                }
                request.setAttribute("patientProgress",subcRegiCasePres);
            }
            request.getRequestDispatcher("progress.jsp").forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void cancelSubcribe(HttpServletRequest request, HttpServletResponse response) {
        String subcId = request.getParameter("subcId");

        if(subcId != null){
            try {
                if(dao.cancelPatientSubcribe(subcId) > 0){
                    response.sendRedirect("progress");
                }else{

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
