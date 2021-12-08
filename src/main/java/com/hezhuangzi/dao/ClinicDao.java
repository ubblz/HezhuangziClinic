package com.hezhuangzi.dao;

import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.util.MyDBUtil;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

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

    public ClinicWorker queryAdminInfo(String clinicId, String pwd, String admintype) throws SQLException {
        Connection connection = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from clinic_worker where clinicId = ? and pwd = ? and typ = ?";
        Object[] params = {clinicId,pwd,admintype};
        ClinicWorker worker = queryRunner.query(connection,sql,params,new BeanHandler<>(ClinicWorker.class));
        DbUtils.close(connection);
        return worker;
    }
}
