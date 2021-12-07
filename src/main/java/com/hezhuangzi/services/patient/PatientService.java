package com.hezhuangzi.services.patient;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.PatientInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class PatientService {
    private PatientDao dao = new PatientDao();

    public void successLogin(HttpServletRequest request, HttpServletResponse response) {
        //获取phone 和 手机号。
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        HttpSession session = request.getSession(true);
        try {
            if(dao.patientLogin(phone,pwd)){
                //查询PatienId 号码
                PatientInfo patientInfo = dao.getPatientInfo(phone);
                String patientId = patientInfo.getPatientId();
                session.setAttribute("phone",phone);
                session.setAttribute("patientId",patientId);
                System.out.println("登陆成功!");
                response.sendRedirect("patientinfo");
            }else{
                System.out.println("登陆失败!");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
//    private PatientSignDao patientSignDao = new PatientSignDao();
//
//    public boolean patientRegister(String phone, String pwd){
//        try {
//            patientSignDao.patientSignUp(phone,pwd);
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean patientLogin(String phone,String pwd){
//        try {
//            return patientSignDao.patientLogin(phone, pwd);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public PatientInfo getPatientInfo(String phone){
//        try {
//            PatientInfo info = patientSignDao.getPatientInfo(phone);
//            return info;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}
