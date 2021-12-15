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
            HttpSession session = request.getSession(true);
            String patientId = ((PatientInfo)session.getAttribute("patientInfo")).getPati_id();

            //查询用户所有的subcribeId
            List<PatientSubcribe> subcribeList = dao.getPatientAllSubcribe(patientId);

//            if(subcribeList.size() == 0){
//                request.setAttribute("patientProgress",null);
//            }else {
                //下一记录
            if(subcribeList != null && !subcribeList.isEmpty() && start < subcribeList.size() && start > -1){

                if (subcribeList.size() > 1 && start + 1 < subcribeList.size()) {
                    request.setAttribute("next", true);
                }
                //上一记录
                if (subcribeList.size() > 1 && start - 1 > -1) {
                    request.setAttribute("pre", true);
                }

                PatientSubcribe subcribe = subcribeList.get(start);
                SubcRegiCasePres subcRegiCasePres = new SubcRegiCasePres();
                subcRegiCasePres.setPatientSubcribe(subcribe); // 设置病人的预约单

                //判断 取消预约按钮  subc_cancel = 0 并且 subc_finish 未完成
                if(subcribe.getSubc_cancel() == 0 && subcribe.getSubc_finish() == 0){
                    request.setAttribute("cancel", true);
                }

                //查询是否有有 爽约的
                Date breakDate = subcribe.getArra_subdate();
                String breakAmpm = subcribe.getArra_ampm();

                if(!OtherUtils.queryBreakTimeDate(breakDate,breakAmpm)){
                    //爽约的是 没取消预约 并且 没完成的 预约单 ，所以取消按钮得小时。
                    request.setAttribute("cancel",false);
                    // 显示爽约信息。
                    request.setAttribute("breakTime",true);
                }

                if (subcribe.getSubc_finish() == 1) {
                    //查找出对应的挂号单
                    PatientRegister register = dao.getPatientRegister(subcribe.getSubc_id());
                    //设置进一整个进度里
                    subcRegiCasePres.setPatientRegister(register);

                    if (register.getRegi_finish() == 1) {

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
