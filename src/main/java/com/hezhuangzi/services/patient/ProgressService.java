package com.hezhuangzi.services.patient;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
            int start = 0; //开始 到 偏移
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));
            }
            request.setAttribute("start",start);

            HttpSession session = request.getSession();
            String patientId = ((PatientInfo)session.getAttribute("patientInfo")).getPatientId();
            PatientInfo patientInfo = dao.getPatientInfo(patientId);

            //查询用户所有的subcribeId
            List<PatientSubcribe> subcribeList = dao.getPatientAllSubcribe(patientId);
            if(subcribeList.size() == 0){
                request.setAttribute("patientProgress",null);
            }else{
                //下一记录
                if(subcribeList.size() > 1 && start+1 < subcribeList.size()){
                    request.setAttribute("next",true);
                }
                //上一记录
                if(subcribeList.size() > 1 && start -1 > -1){
                    request.setAttribute("pre",true);
                }

                List<SubCasehisPres> subCasehisPresList = new ArrayList<>();
                System.out.println(subcribeList.size());

                for (PatientSubcribe patientSubcribe : subcribeList) {
                    //获得 医生
                    ClinicWorker doctor = dao.getSubcribeDoctorInfo(patientSubcribe.getClinicId());
                    //获取 病历信息
                    PatientCaseHistory history = dao.selectCaseHistory(patientSubcribe.getSubcribeId());
                    //获取  处方信息
                    PatientPrescription prescription = dao.selectPrescription(patientSubcribe.getSubcribeId());
//                System.out.println(prescription);

                    //获取 处方的药物信息
                    List<OrderDrug> orderDrugs = null;

                    if(prescription != null){
                        orderDrugs = dao.selectOrderDrug(prescription.getSelectDrug());
                    }

                    //放在一个类中
                    subCasehisPresList.add(new SubCasehisPres(patientInfo,doctor,patientSubcribe,history,prescription,orderDrugs));
                }
//            System.out.println(subCasehisPresList);
                if(subCasehisPresList.get(start).getPatientSubcribe().getFinish() == 0){
                    request.setAttribute("cancel",true);
                }

                request.setAttribute("patientProgress",subCasehisPresList.get(start));
//                request.setAttribute("patientProgress",null);
            }
            request.getRequestDispatcher("progress.jsp").forward(request,response);
        } catch (ServletException e) {
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
        String cancel = request.getParameter("cancel");

        if(cancel != null){
            try {
                if(dao.cancelPatientSubcribe(cancel)){
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
