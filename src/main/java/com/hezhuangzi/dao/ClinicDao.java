package com.hezhuangzi.dao;

import com.hezhuangzi.entity.ArragneDoctor;
import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.util.MyDBUtil;
import com.hezhuangzi.util.OtherUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.ehcache.impl.internal.loaderwriter.writebehind.NonBatchingLocalHeapWriteBehindQueue;
import sun.applet.AppletEventMulticaster;

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

    public List<ClinicWorker> queryArrange(String date, String sector, String time) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select * " +
                "from clinic_worker as c " +
                "where " +
                "!(c.clinicId in (select a.clinicId from arrange_doctor as a " +
                "INNER JOIN clinic_worker c " +
                "on a.clinicId = c.clinicId and a.subdate = ? and a.ampm = ?)) and c.typ = ?";
        Object[] params = {date,time,sector};
        List<ClinicWorker> list = qr.query(conn,sql,params,new BeanListHandler<>(ClinicWorker.class));

        DbUtils.close(conn);
        return list;
    }

    public int arrangeOneDoctor(String clinicId, String date, String ampm, String subnum) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "insert into arrange_doctor(clinicId,subnum,ampm,subdate) values(?,?,?,?)";
        Object[] params = {clinicId,subnum,ampm,date};
        int count = qr.execute(conn,sql,params);
        DbUtils.close(conn);
        return count;
    }

    public List<ArragneDoctor> queryArrangeDoctor() throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select *  from arrange_doctor as a " +
                "INNER JOIN clinic_worker as c " +
                "on a.clinicId = c.clinicId ";
//        Object[] params = {};
        List<ArragneDoctor> list = qr.query(conn,sql,new BeanListHandler<>(ArragneDoctor.class));
        DbUtils.close(conn);
        return list;
    }

    public boolean cancelArrangeDoctor(String arrangeId) throws SQLException {
        Connection conn = MyDBUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "delete from arrange_doctor where arrangeId = ?";
        Object[] params = {arrangeId};
        int count  = qr.execute(conn,sql,params);
        DbUtils.close(conn);
        return count>0?true:false;
    }
}
