package com.hezhuangzi.dao;

import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.util.MyDBUtil;
import com.hezhuangzi.util.OtherUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

    public void addExcelData(List<ClinicWorker> dataList) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into clinic_worker(clinicId,cname,gen,birth,age,post,phone,pic,typ,pwd) values(?,?,?,?,?,?,?,?,?,?)";
        for (ClinicWorker worker : dataList) {
            Object[] params = {worker.getClinicId(),worker.getCname(),worker.getGen(), OtherUtils.dateConvert(worker.getBirth()),worker.getAge(),
            worker.getPost(),worker.getPhone(),worker.getPic(),worker.getTyp(),worker.getPwd()};
            queryRunner.execute(conn,sql,params);
        }
        DbUtils.close(conn);
    }
}
