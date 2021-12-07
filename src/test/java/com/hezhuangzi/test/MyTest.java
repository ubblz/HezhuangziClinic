package com.hezhuangzi.test;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.ArragneDoctor;
import com.hezhuangzi.entity.ChooseDoctor;
import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.entity.MinMaxDate;
import com.hezhuangzi.util.OtherUtils;
import com.mysql.cj.xdevapi.SchemaImpl;
import org.junit.Test;

import java.lang.reflect.AnnotatedArrayType;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testDate() throws ParseException {
        PatientDao dao = new PatientDao();
        try {
            MinMaxDate date = dao.getSubMinMaxDate();
            Date date1 = new Date();
            if(date1.compareTo(date.getMinDate()) > 0){
                System.out.println("date > min");
            }
            System.out.println(date);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void selectDoctor() throws SQLException {
        PatientDao dao = new PatientDao();
        List doctorList = dao.selectDoctor("2021-12-05","erke","amsubnum");
        for (Object o : doctorList) {
            System.out.println(o);
        }
    }


    @Test
    public void arrangeIdDoctor() throws SQLException {
        PatientDao dao = new PatientDao();
        ArragneDoctor worker = dao.getDoctorInfo("3");
        System.out.println(worker);
    }
    @Test
    public  void  test(){
        System.out.println(OtherUtils.subcribeNum().length());

    }
}
