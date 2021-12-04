package com.hezhuangzi.services.patient;

import com.hezhuangzi.dao.PatientSignDao;

import java.sql.SQLException;

public class SignService {
    private PatientSignDao patientSignDao = new PatientSignDao();

    public boolean patientSignUp(String phone, String pwd){
        try {
            patientSignDao.patientSignUp(phone,pwd);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean signIn(String phone ,String pwd){
        return true;
    }
}
