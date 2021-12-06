package com.hezhuangzi.dao;

import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.util.MyDBUtil;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class ClinicDao {
//    录入医生的信息
    public void addDoctorInfo(ClinicWorker worker) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "";

        DbUtils.close(conn);
    }
}
