package com.hezhuangzi.dao;

import com.hezhuangzi.entity.*;
import com.hezhuangzi.util.MyDBUtil;
import com.hezhuangzi.util.OtherUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.awt.*;
import java.lang.reflect.AnnotatedArrayType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class PatientDao {
    //注册
    public void  patientSignUp(String phone, String pwd) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String patientId = "p"+ OtherUtils.getCurrentTimeMillis();
        String sql = "INSERT INTO patient_info(patientId,phone,pwd) VALUES(?,?,?)";
        Object[] params = {patientId,phone,pwd};
        queryRunner.execute(conn,sql,params);
        DbUtils.close(conn);
    }

    //登陆
    public PatientInfo patientLogin(String phone,String pwd) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM patient_info WHERE phone= ? AND pwd = ?";
        Object[] params = {phone,pwd};
        PatientInfo patientInfo = queryRunner.query(conn,sql,params,new BeanHandler<>(PatientInfo.class));
        DbUtils.close(conn);
        return patientInfo;
    }


    //获取登陆用户的信息
    public PatientInfo getPatientInfo(String patientId) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM patient_info WHERE patientId = ?";
        Object[] params = {patientId};
        PatientInfo patientInfo = queryRunner.query(conn,sql,params,new BeanHandler<>(PatientInfo.class));
        DbUtils.close(conn);
        return patientInfo;
    }

    //获取登陆用户的信息
//    public PatientInfo getPatientInfoById(String patientId) throws SQLException {
//        Connection conn = MyDBUtil.getConnection();
//        QueryRunner queryRunner = new QueryRunner();
//        String sql = "SELECT * FROM patient_info WHERE patientId = ?";
//        Object[] params = {patientId};
//        PatientInfo patientInfo = queryRunner.query(conn,sql,params,new BeanHandler<>(PatientInfo.class));
//        DbUtils.close(conn);
//        return patientInfo;
//    }

/*
* String name = request.getParameter("modifyname");
        String gen = request.getParameter("modifygen");
        String age = request.getParameter("modifyage");
        String icard = request.getParameter("modifyicard");
        String phone = request.getParameter("modifyphone");
        String email = request.getParameter("modifyemail");
* */
    public int updatePatientInfo(String patientId,String name,String age,String gen,String icard,String email) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "UPDATE patient_info SET age=?,gen=?,icard=?,name=?,email=?,getinfo=1 WHERE patientId = ?";
        Object[] params = {age,gen,icard,name,email,patientId};
        int count = queryRunner.execute(conn,sql,params);
        DbUtils.close(conn);
        return count;
    }

    public MinMaxDate getSubMinMaxDate() throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        MinMaxDate date = new MinMaxDate();
        QueryRunner qr = new QueryRunner();
        String maxSql = "SELECT max(subdate) FROM arrange_doctor";
        String minSql = "SELECT min(subdate) FROM arrange_doctor";
        Date max = (Date) qr.query(conn,maxSql,new ScalarHandler());
        Date min = (Date) qr.query(conn,minSql,new ScalarHandler());
        date.setMinDate(min);
        date.setMaxDate(max);
        DbUtils.close(conn);
        return date;
    }

    //查询预约的医生信息
    public List selectDoctor(String date, String sector, String time) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
//        String sql = "select arrangeId,c.clinicId as clinicId,amsubnum,pmsubnum,subdate,cname,gen,birth,age,post,pic phone,typ from arrange_doctor as a " +
//                "inner join clinic_worker as c " +
//                "on a.clinicId = c.clinicId and subdate="+date+" and post = "+ sector +" and "+time+ " <> 0;";
        String sql = "select arrangeId,c.clinicId as clinicId,subnum,subdate,cname,gen,birth,age,post,pic,phone,typ from arrange_doctor as a " +
                "inner join clinic_worker as c " +
                "on a.clinicId = c.clinicId and subdate= ? and post = ? and subnum <> 0 and ampm = ?";
        Object[] params = {date,sector,time};
//        System.out.println(sql);
        List doctorList = queryRunner.query(conn,sql,params,new MapListHandler());
//        List doctorList = queryRunner.query(conn,sql,new MapListHandler());
//        List<ChooseDoctor> doctorList = queryRunner.query(conn,sql,params,new BeanListHandler<>(ChooseDoctor.class));

        DbUtils.close(conn);
        return doctorList;
    }

    public ArragneDoctor getDoctorInfo(String arrangeId) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT a.* FROM clinic_worker as c " +
                "inner join arrange_doctor as a " +
                "on a.arrangeId = ? and c.clinicId  = a.clinicId ;";
        Object[] params = {arrangeId};
        ArragneDoctor doctor = queryRunner.query(conn,sql, params,new BeanHandler<>(ArragneDoctor.class));
        DbUtils.close(conn);
        return doctor;
    }

    public boolean addPatientSubcribe(ArragneDoctor arragneDoctor, PatientInfo patientInfo) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into " +
                "patient_subcribe(subcribeId,patientId,ampm,clinicId,cancelSub,breakTime,finish,subTime) " +
                "values(?,?,?,?,?,?,?,?)";
        Object[] params = {OtherUtils.subcribeNum(),
                patientInfo.getPatientId(),
                arragneDoctor.getAmpm(),
        arragneDoctor.getClinicId(),
        0,0,0,arragneDoctor.getSubdate()};
        int count = queryRunner.execute(conn,sql,params);
        DbUtils.close(conn);
        return count > 0;
    }

    public List<PatientSubcribe> getPatientAllSubcribe(String patientId) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select * from patient_subcribe where patientId = ? ORDER BY subcribeId DESC";
        Object[] params = {patientId};
        List<PatientSubcribe> list = qr.query(conn,sql,params,new BeanListHandler<>(PatientSubcribe.class));
        DbUtils.close(conn);
        return list;
    }

    public PatientCaseHistory selectCaseHistory(String subcribeId) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from patient_casehistory where subcribeId = ?";
        Object[] params = {subcribeId};
        PatientCaseHistory history = queryRunner.query(conn,sql,params,new BeanHandler<>(PatientCaseHistory.class));
        DbUtils.close(conn);
//        System.out.println(history);
        return history;
    }

    public PatientPrescription selectPrescription(String subcribeId) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from patient_prescription where subcribeId = ?";
        Object[] params = {subcribeId};
        PatientPrescription query = queryRunner.query(conn, sql, params, new BeanHandler<>(PatientPrescription.class));
        DbUtils.close(conn);
        return query;
    }

    public List<OrderDrug> selectOrderDrug(Integer selectDrug) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT o.* from patient_prescription as p " +
                "INNER JOIN order_drug as o " +
                "ON p.selectDrug = o.selectDrug and o.selectDrug = ?";
        System.out.println(sql);
        Object[] params = {selectDrug};
        List<OrderDrug> drugList = queryRunner.query(conn,sql,params,new BeanListHandler<>(OrderDrug.class));
        DbUtils.close(conn);
        return drugList;
    }

    public ClinicWorker getSubcribeDoctorInfo(String clinicId) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from clinic_worker where clinicId = ?";
        Object[] params = {clinicId};
        ClinicWorker query = queryRunner.query(conn, sql, params, new BeanHandler<>(ClinicWorker.class));
//        System.out.println(query);
        DbUtils.close(conn);
        return query;
    }

    public boolean queryAlreaySubcribe(String arrangeId) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from patient_subcribe where patientId = ? and finish = 0;";
        Object[] params = {arrangeId};
        PatientSubcribe subcribe = queryRunner.query(conn,sql,params,new BeanHandler<>(PatientSubcribe.class));
        DbUtils.close(conn);
        return subcribe != null;
    }

    public Map queryBreakTime(String arrangeId) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from patient_subcribe where patientId = ? and breakTime = 1;";
        Object[] params = {arrangeId};
        Map subcribe = queryRunner.query(conn,sql,params,new MapHandler());
        DbUtils.close(conn);
        return subcribe;
    }

    public boolean cancelPatientSubcribe(String cancel) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "delete from patient_subcribe where subcribeId = ?";
        Object[] params = {cancel};
        int count = queryRunner.execute(conn,sql,params);


        DbUtils.close(conn);
        return count > 0;
    }
}
