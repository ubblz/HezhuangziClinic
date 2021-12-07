package com.hezhuangzi.services.patient;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.ArragneDoctor;
import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.entity.PatientInfo;

import java.sql.SQLException;

public class SubcribeService {


    public boolean addSub(String arrangeId, String phone) {
        PatientDao dao = new PatientDao();
        try {
            ArragneDoctor dcotor = dao.getDoctorInfo(arrangeId);
            PatientInfo patientInfo = dao.getPatientInfo(phone);
            if(dao.addPatientSubcribe(dcotor,patientInfo)){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
