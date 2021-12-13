package com.hezhuangzi.test;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.*;
import com.hezhuangzi.util.MySqlDBUtil;
import com.hezhuangzi.util.OtherUtils;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

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
        List doctorList = dao.querySubcribeDoctor("2021-12-05","erke","amsubnum");
        for (Object o : doctorList) {
            System.out.println(o);
        }
    }


    @Test
    public void arrangeIdDoctor() throws SQLException {
        PatientDao dao = new PatientDao();
        ArrangeDoctor worker = dao.getDoctorInfo("3");
        System.out.println(worker);
    }
    @Test
    public  void  test() throws SQLException {
        System.out.println(new Date());
    }
    @Test
    public void queryBreakTime() throws SQLException {
//        PatientDao dao = new PatientDao();
//        boolean p211204173202 = dao.queryAlreaySubcribe("p211204173202");
//        System.out.println(p211204173202);
    }

    @Test
    public void DateTest(){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date nowDate = new Date();
//        int count = 0;
//        while(!OtherUtils.dateToWeek(simpleDateFormat.format(nowDate)).equals("星期一")){
//            Calendar calendar = new GregorianCalendar();
//            calendar.setTime(nowDate);
//            calendar.add(Calendar.DATE,1);
//            count++;
//            nowDate = calendar.getTime();
//        }
//        System.out.println(count);
//        System.out.println(OtherUtils.getMondayDate());
    }

    @Test
    public void queryDate() throws SQLException {
//        LocalTime nowTime = LocalTime.now();
//        LocalTime t = LocalTime.of(7,0,0);
//        LocalTime time8 = LocalTime.of(8,0,0);
//        if (t.compareTo(time8)>0) {
//            System.out.println("大于");
//        }else{
//            System.out.println("小于");
//        }

//        System.out.println(OtherUtils.getAmPm(LocalTime.of(8,30,0)));
//        PatientDao dao = new PatientDao();
//        ArrangeDoctor arrangeDoctor = dao.queryWhetherBreak();
//        Date subMaxDate = arrangeDoctor.getArra_subdate();
//        String subMaxAmPm = arrangeDoctor.getArra_ampm();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String subMaxStr = sdf.format(subMaxDate);
//        System.out.println(subMaxStr);
//        Date nowDate = new Date();
//        String nowStr = sdf.format(nowDate);
//        System.out.println(nowStr);
//        if(subMaxStr.equals("2021-12-16")){
//            System.out.println("相同");
//        }

//        if(OtherUtils.sameDate(subMaxDate)){
//            System.out.println("相同");
//        }else{
//            System.out.println("不相同");
//        }

//        if(nowDate.compareTo(subMaxDate) > 0){
//            System.out.println("大于");
//        }else{
//            System.out.println("小于");
//        }

    }
    @Test
    public void insertTest() throws SQLException {
//        String sql = "insert into order_drug(pres_id,drug_id,order_num) values(?,?,?)";
//        Object[] params = {1,2,3};
//        BigInteger id = MySqlDBUtil.testBean(sql,params);
//        System.out.println(id);
    }

}
