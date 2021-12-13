package com.hezhuangzi.dao;

import com.hezhuangzi.entity.*;
import com.hezhuangzi.util.MySqlDBUtil;
import com.hezhuangzi.util.OtherUtils;
import org.apache.commons.dbutils.QueryRunner;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PatientDao {
    //Map MapList Array ArrayList Bean BeanList

    //注册
    public int  patientSignUp(String phone, String pwd) throws SQLException {
        String patientId = "p"+ OtherUtils.getCurrentTimeMillis();
        String sql = "INSERT INTO patient_info(pati_id,pati_phone,pati_pwd) VALUES(?,?,?)";

        Object[] params = {patientId,phone,pwd};

        int effect = MySqlDBUtil.insert(sql,params);

        return effect;
    }

    //登陆
    public PatientInfo patientLogin(String phone,String pwd) throws SQLException {
        String sql = "SELECT * FROM patient_info WHERE pati_phone= ? AND pati_pwd = ?";
        Object[] params = {phone,pwd};
        PatientInfo patientInfo = MySqlDBUtil.queryBean(sql,params,PatientInfo.class);
        return patientInfo;
    }

    //获取登陆用户的信息
    public PatientInfo getPatientInfo(String patientId) throws SQLException {
        String sql = "SELECT * FROM patient_info WHERE pati_id = ?";
        Object[] params = {patientId};
        PatientInfo patientInfo = MySqlDBUtil.queryBean(sql, params, PatientInfo.class);
        return patientInfo;
    }

    public int updatePatientInfo(String patientId,String name,String age,String gen,String icard,String email) throws SQLException {
        String sql = "UPDATE patient_info SET pati_age=?,pati_gen=?,pati_icard=?,pati_name=?,pati_email=?,pati_getinfo=1 WHERE pati_id = ?";
        Object[] params = {age,gen,icard,name,email,patientId};
        int effect = MySqlDBUtil.update(sql,params);
        return effect;
    }

    public MinMaxDate getSubMinMaxDate() throws SQLException {
        MinMaxDate date = new MinMaxDate();
        QueryRunner qr = new QueryRunner();
        String maxSql = "SELECT max(arra_subdate) FROM arrange_doctor";
        String minSql = "SELECT min(arra_subdate) FROM arrange_doctor";
        Date max = MySqlDBUtil.queryScalar(maxSql);
        Date min = MySqlDBUtil.queryScalar(minSql);
        date.setMinDate(min);
        date.setMaxDate(max);
        return date;
    }
                            /*
                            * 改
                            * */
    //查询预约的医生信息
    public List<ArrangeDoctor> querySubcribeDoctor(String date, String sector, String time) throws SQLException {
        String sql = "SELECT * from clinic_worker as c " +
                "INNER JOIN arrange_doctor as a " +
                "on c.clin_id = a.clin_id and c.clin_type = ? and a.arra_subdate = ? and a.arra_ampm = ? and a.arra_subnum <> 0";
        Object[] params = {sector,date,time};
        List<ArrangeDoctor>  queryDoctorList = MySqlDBUtil.queryBeanList(sql,params, ArrangeDoctor.class);
        return queryDoctorList;
    }

    public ArrangeDoctor getDoctorInfo(String arrangeId) throws SQLException {
        String sql = "SELECT a.* FROM clinic_worker as c " +
                "inner join arrange_doctor as a " +
                "on a.arra_id = ? and c.clin_id  = a.clin_id ;";
        Object[] params = {arrangeId};
        ArrangeDoctor doctor = MySqlDBUtil.queryBean(sql, params, ArrangeDoctor.class);
        return doctor;
    }

    public int addPatientSubcribe(String arraryId, String pati_id) throws SQLException {
        String sql = "insert into " +
                "patient_subcribe(" +
                "subc_id," +
                "pati_id," +
                "arra_id," +
                "subc_cancel," +
                "subc_break," +
                "subc_finish) " +
                "values(?,?,?,?,?,?)";
        Object[] params = {OtherUtils.subcribeNum(),pati_id, arraryId, 0,0,0};
        String updateSql = "update arrange_doctor set arra_subnum=arra_subnum-1 where arra_id = ?";
        Object[] params2 = {arraryId};
        int updateEffect = MySqlDBUtil.update(updateSql,params2);
        int effect = MySqlDBUtil.insert(sql,params);
        return effect;
    }

    public List<PatientSubcribe> getPatientAllSubcribe(String patientId) throws SQLException {
        String sql = "select * from patient_subcribe as subc " +
                "inner join patient_info as info " +
                "on subc.pati_id = info.pati_id and subc.pati_id = ? " +
                "inner join arrange_doctor as arra " +
                "on subc.arra_id = arra.arra_id " +
                "inner join clinic_worker as clin " +
                "on arra.clin_id = clin.clin_id " +
                "ORDER BY subc_id desc ";
        Object[] params = {patientId};
        List<PatientSubcribe> list = MySqlDBUtil.queryBeanList(sql,params,PatientSubcribe.class);
        return list;
    }

    public PatientCaseHistory selectCaseHistory(String subcribeId) throws SQLException {
        String sql = "select * from patient_casehistory where subc_id = ?";
        Object[] params = {subcribeId};
        PatientCaseHistory history = MySqlDBUtil.queryBean(sql,params,PatientCaseHistory.class);
        return history;
    }

    public PatientPrescription selectPrescription(String subcribeId) throws SQLException {
        String sql = "select * from patient_prescription where subc_id = ?";
        Object[] params = {subcribeId};
        PatientPrescription query = MySqlDBUtil.queryBean(sql, params,PatientPrescription.class);
        return query;
    }

    public List<OrderDrug> selectOrderDrug(String presid) throws SQLException {
        String sql = "SELECT o.* from patient_prescription as p " +
                "INNER JOIN order_drug as o " +
                "ON p.pres_id = o.pres_id and o.pres_id = ?";
        System.out.println(sql);
        Object[] params = {presid};
        List<OrderDrug> drugList = MySqlDBUtil.queryBeanList(sql,params,OrderDrug.class);
        return drugList;
    }

    public ClinicWorker getSubcribeDoctorInfo(String clinicId) throws SQLException {
        String sql = "select * from clinic_worker where clin_id = ?";
        Object[] params = {clinicId};
        ClinicWorker query = MySqlDBUtil.queryBean(sql, params,ClinicWorker.class);
        return query;
    }

    public boolean queryAlreaySubcribe(String patiId) throws SQLException {
        String sql = "select * from patient_subcribe where pati_id = ? and subc_cancel = 0 and subc_finish = 0;";
        Object[] params = {patiId};
        PatientSubcribe subcribe = MySqlDBUtil.queryBean(sql,params,PatientSubcribe.class);
        return subcribe != null;
    }

    public Map queryPatientBreak(String patiId) throws SQLException {
        String sql = "select  from patient_subcribe where pati_id = ? and subc_break = 1;";
        Object[] params = {patiId};
        Map subcribe = MySqlDBUtil.queryMap(sql,params);
        return subcribe;
    }

    public int cancelPatientSubcribe(String subcId) throws SQLException {
        String sql = "update patient_subcribe set subc_cancel = 1 where subc_id = ?";
        String sqlAdd = "update arrange_doctor set arra_subnum = arra_subnum + 1 where arra_id in (select arra_id from patient_subcribe where subc_id = ?)";
        Object[] params = {subcId};
        int effect = MySqlDBUtil.delete(sql,params);
        int addEffect = MySqlDBUtil.update(sqlAdd,params);
        return effect;
    }

    public ArrangeDoctor queryWhetherBreak(String pati_id) throws SQLException {

        String sql = "select max(arra_subdate) as arra_subdate,a.arra_ampm  from patient_subcribe as p " +
                "inner join arrange_doctor as a " +
                "on p.arra_id = a.arra_id and p.subc_finish = 0 and p.subc_cancel = 0 and p.pati_id = ?";
        Object[] params = {pati_id};
        ArrangeDoctor arragneDoctor = MySqlDBUtil.queryBean(sql,params, ArrangeDoctor.class);

        return arragneDoctor;
    }

    public PatientRegister getPatientRegister(String subc_id) throws SQLException {
        String sql = "select * from patient_register as regi " +
                "inner join clinic_worker as clin " +
                "on regi.regi_clin_id = clin.clin_id and regi.subc_id = ?;";
        Object[] params = {subc_id};
        PatientRegister patientRegister = MySqlDBUtil.queryBean(sql,params,PatientRegister.class);
        return patientRegister;
    }

    public PatientCaseHistory getPatientCaseHistory(String regi_id) throws SQLException {
        String sql = "select * from patient_casehistory where regi_id = ?";
        Object[] params = {regi_id};
        PatientCaseHistory patientCaseHistory = MySqlDBUtil.queryBean(sql,params,PatientCaseHistory.class);
        return patientCaseHistory;
    }

    public PatientPrescription getPatientPrescription(String regi_id) throws SQLException {
        String sql = "select * from patient_prescription where regi_id = ?";
        Object[] params = {regi_id};
        PatientPrescription patientPrescription = MySqlDBUtil.queryBean(sql,params,PatientPrescription.class);
        return patientPrescription;
    }

    public List<OrderDrug> getOrderDrug(String pres_id) throws SQLException {
        String sql = "SELECT * from order_drug as o " +
                "INNER JOIN drug_repository as d " +
                "on pres_id = ? and o.drug_id = d.drug_id;";
        Object[] params = {pres_id};
        List<OrderDrug> orderDrugList = MySqlDBUtil.queryBeanList(sql,params,OrderDrug.class);
        return orderDrugList;
    }
}
