package com.hezhuangzi.test;

import com.hezhuangzi.dao.PatientDao;
import org.junit.Test;

import java.sql.SQLException;

public class MyTest {
    @Test
    public void insertPatient() throws SQLException {
        PatientDao dao = new PatientDao();
        dao.patientSignUp("13414093561","123");

    }

    @Test
    public void updatTest(){
        PatientDao dao = new PatientDao();
        try {
            int count = dao.updatePatientInfo("13414093561","1","1","1","1","2");
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
