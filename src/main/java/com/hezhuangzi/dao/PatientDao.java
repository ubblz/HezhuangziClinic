package com.hezhuangzi.dao;

import com.hezhuangzi.entity.PatientInfo;
import com.hezhuangzi.util.MyDBUtil;
import com.hezhuangzi.util.OtherUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

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
    public boolean patientLogin(String phone,String pwd) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM patient_info WHERE phone="+phone+" AND pwd = " + pwd;
        PatientInfo patientInfo = queryRunner.query(conn,sql,new BeanHandler<>(PatientInfo.class));
        DbUtils.close(conn);
        if(patientInfo != null){
            return true;
        }else{
            return false;
        }
    }


    //获取登陆用户的信息
    public PatientInfo getPatientInfo(String phone) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM patient_info WHERE phone="+phone;
        PatientInfo patientInfo = queryRunner.query(conn,sql,new BeanHandler<>(PatientInfo.class));
        DbUtils.close(conn);
        if(patientInfo != null){
            return patientInfo;
        }else{
            return null;
        }
    }
/*
* String name = request.getParameter("modifyname");
        String gen = request.getParameter("modifygen");
        String age = request.getParameter("modifyage");
        String icard = request.getParameter("modifyicard");
        String phone = request.getParameter("modifyphone");
        String email = request.getParameter("modifyemail");
* */
    public int updatePatientInfo(String phone,String name,String age,String gen,String icard,String email) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "UPDATE patient_info SET age=?,gen=?,icard=?,name=?,email=?,getinfo=1 WHERE phone = ?";
        Object[] params = {age,gen,icard,name,email,phone};
        int count = queryRunner.execute(conn,sql,params);
        DbUtils.close(conn);

        return count;
    }




}
