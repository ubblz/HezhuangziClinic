package com.hezhuangzi.test;

import com.hezhuangzi.dao.PatientSignDao;
import org.junit.Test;

import java.sql.SQLException;

public class MyTest {
    @Test
    public void insertPatient() throws SQLException {
        PatientSignDao dao = new PatientSignDao();
        dao.patientSignUp("13414093561","123");

    }
}
