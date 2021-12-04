package com.hezhuangzi.dao;

import com.hezhuangzi.util.MyDBUtil;
import com.hezhuangzi.util.OtherUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class PatientSignDao {
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

        return true;
    }




}
