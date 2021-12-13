package com.hezhuangzi.dao;

import com.hezhuangzi.entity.*;
import com.hezhuangzi.util.MySqlDBUtil;
import com.hezhuangzi.util.OtherUtils;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

public class ClinicDao {


    public ClinicWorker queryAdminInfo(String clinicId, String pwd, String admintype) throws SQLException {
        String sql = "select * from clinic_worker where clin_id = ? and clin_pwd = ? and clin_type = ?";
        Object[] params = {clinicId,pwd,admintype};
        ClinicWorker worker = MySqlDBUtil.queryBean(sql,params,ClinicWorker.class);
        return worker;
    }

    public void addExcelData(List<ClinicWorker> dataList) throws SQLException {
        String sql = "insert into clinic_worker(clin_id,clin_name,clin_gen,clin_birth,clin_age,clin_post,clin_pic,clin_phone,clin_type,clin_pwd) values(?,?,?,?,?,?,?,?,?,?)";
        for (ClinicWorker worker : dataList) {
            Object[] params = {worker.getClin_id(),worker.getClin_name(),worker.getClin_gen(), OtherUtils.dateConvert(worker.getClin_birth()),worker.getClin_age(),
            worker.getClin_post(),worker.getClin_pic(),worker.getClin_phone(),worker.getClin_type(),worker.getClin_pwd()};
            MySqlDBUtil.insert(sql,params);
        }
    }

    public List<ClinicWorker> queryArrange(String date, String sector, String time) throws SQLException {
        String sql = "select * " +
                "from clinic_worker as c " +
                "where " +
                "!(c.clin_id in (select a.clin_id from arrange_doctor as a " +
                "INNER JOIN clinic_worker c " +
                "on a.clin_id = c.clin_id and a.arra_subdate = ? and a.arra_ampm = ?)) and c.clin_type = ?";
        Object[] params = {date,time,sector};
        List<ClinicWorker> list = MySqlDBUtil.queryBeanList(sql,params,ClinicWorker.class);
        return list;
    }

    public int arrangeOneDoctor(String clinicId, String date, String ampm, String subnum) throws SQLException {
        String sql = "insert into arrange_doctor(clin_id,arra_subnum,arra_ampm,arra_subdate) values(?,?,?,?)";
        Object[] params = {clinicId,subnum,ampm,date};
        int effect = MySqlDBUtil.insert(sql,params);
        return effect;
    }

    public List<ArrangeDoctor> queryArrangeDoctor() throws SQLException {
        String sql = "select *  from arrange_doctor as a " +
                "INNER JOIN clinic_worker as c " +
                "on a.clin_id = c.clin_id ";
//        Object[] params = {};
        List<ArrangeDoctor> list = MySqlDBUtil.queryBeanList(sql, ArrangeDoctor.class);
        return list;
    }

    public int cancelArrangeDoctor(String arrangeId) throws SQLException {
        String sql = "delete from arrange_doctor where arra_id = ?";
        Object[] params = {arrangeId};
        int effect  = MySqlDBUtil.delete(sql,params);
        return effect;
    }

    public ClinicWorker clinicWorkerLogin(String clinicId, String pwd, String type) throws SQLException {
        String sql = "select * from clinic_worker where clin_id = ? and clin_pwd = ? and clin_type = ?";
        Object[] params = {clinicId,pwd,type};
        ClinicWorker clinicWorker  = MySqlDBUtil.queryBean(sql,params,ClinicWorker.class);
        return clinicWorker;
    }

    public PatientSubcribe guidanceGetSubcribe(String subcribeId,String sector) throws SQLException {
        String sql = "select * " +
                "from patient_subcribe as subc " +
                "inner JOIN arrange_doctor as arra " +
                "inner join clinic_worker as clin " +
                "on subc.subc_id = ? and subc.subc_cancel = 0 and subc.subc_finish = 0 and subc.arra_id = arra.arra_id and arra.clin_id = clin.clin_id and clin.clin_type = ?;";
        Object[] params = {subcribeId,sector};
        PatientSubcribe subcribe = MySqlDBUtil.queryBean(sql,params,PatientSubcribe.class);
        return subcribe;
    }

    public int releaseRegister(String subcribeId, String clinId) throws SQLException {
        String regiId = OtherUtils.getCurrentTimeMillis();
        String sql = "insert into patient_register(regi_id,subc_id,regi_clin_id,regi_finish) values(?,?,?,?)";
        String finishSql = "update patient_subcribe set subc_finish = 1 where subc_id = ?";
        Object[] finishParams = {subcribeId};
        Object[] params = {regiId,subcribeId,clinId,0};
        int effect = MySqlDBUtil.insert(sql,params);
        int finishEffect = MySqlDBUtil.update(finishSql,finishParams);
        return effect;
    }

    public List<PatientRegister> getSectorRegister(String sector) throws SQLException {
        String sql = "SELECT * from patient_register as regi " +
                "INNER JOIN patient_subcribe as subc " +
                "inner join arrange_doctor as arra " +
                "INNER JOIN patient_info as pati " +
                "INNER JOIN clinic_worker as clin " +
                "on regi.subc_id = subc.subc_id and subc.pati_id = pati.pati_id and arra.arra_id = subc.arra_id and arra.clin_id = clin.clin_id and clin.clin_type = ? and regi.regi_finish = 0";
        Object[] params = {sector};
        List<PatientRegister> patientRegister = MySqlDBUtil.queryBeanList(sql,params,PatientRegister.class);
        return patientRegister;
    }

    //根据医生的id查
    public List<PatientRegister> getSectorPatient(String clinId) throws SQLException {
        String sql = "SELECT * FROM patient_subcribe AS subc " +
                "INNER JOIN arrange_doctor AS arra " +
                "INNER JOIN patient_info AS pati " +
                "INNER JOIN clinic_worker AS clin " +
                "INNER JOIN patient_register AS regi " +
                "ON subc.arra_id = arra.arra_id AND arra.clin_id = arra.clin_id AND subc.pati_id = pati.pati_id AND arra.clin_id = clin.clin_id AND regi.subc_id = subc.subc_id AND clin.clin_id = ? AND regi.regi_finish = 0";
        Object[] params = {clinId};
        List<PatientRegister> list = MySqlDBUtil.queryBeanList(sql,params,PatientRegister.class);
        return list;
    }

    public int registerFinish(String regi_id) throws SQLException {
        String sql = "update patient_register set regi_finish = 1 where regi_id = ?";
        Object[] params = {regi_id};
        int effect = MySqlDBUtil.update(sql,params);
        return effect;
    }

    public int writeCaseHistory(String regiId, String hpi) throws SQLException {
        String sql = "insert into patient_casehistory(regi_id,case_hpi) values(?,?)";
        Object[] params = {regiId,hpi};
        return MySqlDBUtil.insert(sql,params);
    }

    public List<DrugRepository> searchDrugRepository(String drugName) throws SQLException {
        String sql = "select * from drug_repository where drug_name like '%"+drugName+"%'";
        Object[] params = {drugName};
        List<DrugRepository> list = MySqlDBUtil.queryBeanList(sql,DrugRepository.class);
        return  list;
    }

    private boolean queryChoose(String regiId) throws SQLException {
        String sql = "select * from patient_prescription where regi_id = ?";
        Object[] params = {regiId};
        PatientPrescription patientPrescription = MySqlDBUtil.queryBean(sql,params,PatientPrescription.class);
        return  patientPrescription != null;
    }

    public int doctorChooseMethod(String regiId, String choose) throws SQLException {
        String sql;
        Object[] params;
        if(queryChoose(regiId)){//存在
            sql = "update patient_prescription set pres_choose = ? where regi_id = ?";
            params = new Object[]{choose,regiId};
        }else{
            sql = "insert into patient_prescription(regi_id,pres_choose) values(?,?)";
            params = new Object[]{regiId,choose};
        }
        int effect = MySqlDBUtil.insert(sql,params);
        return effect;
    }
    public String regiIdToPresId(String regiId) throws SQLException {
        String sql  = "select * from patient_prescription where regi_id = ?";
        Object[] params = {regiId};
        PatientPrescription patientPrescription = MySqlDBUtil.queryBean(sql,params,PatientPrescription.class);
        return patientPrescription.getPres_id();
    }

    public BigInteger insertPresDrug(String regiId, String drugId, String chooseNum) throws SQLException {
        String presId = regiIdToPresId(regiId);
        String sql = "insert into order_drug(pres_id,drug_id,order_num) values(?,?,?)";
        Object[] params = {presId, drugId,chooseNum};
        BigInteger effect = MySqlDBUtil.insertGetId(sql,params);
        return effect;
    }

    public int devDrugNum(String drugId ,String chooseNum) throws SQLException {
        int num = Integer.parseInt(chooseNum);
        String sql = "update drug_repository set drug_num = drug_num - ? where drug_id = ?";
        Object[] params = {num,drugId};
        int effect = MySqlDBUtil.update(sql,params);
        return effect;
    }

    public OrderDrug getCancelDrugNum(String orderId) throws SQLException {
        String sql = "select * from order_drug as o ,drug_repository as d where o.drug_id = d.drug_id and  o.order_id = ?";
        OrderDrug d = MySqlDBUtil.queryBean(sql,new Object[]{orderId},OrderDrug.class);
        return d;
    }


    public int cancelChoseDrug(String orderId) throws SQLException {
        String sql = "delete from order_drug where order_id = ?";
        return MySqlDBUtil.delete(sql,new Object[]{orderId});
    }

    public int updateCancelDrugNum(OrderDrug num) throws SQLException {
        int choseNum = num.getDrug_num();
        int drugId = num.getDrug_id();
        String sql = "update drug_repository set drug_num = drug_num + ? where drug_id = ?";
        return MySqlDBUtil.update(sql,new Object[]{choseNum,drugId});
    }

    public PatientRegister getPatientRegister(String subcId) throws SQLException {
        String sql = "SELECT * FROM patient_subcribe AS subc " +
                "INNER JOIN arrange_doctor AS arra " +
                "INNER JOIN patient_info AS pati " +
                "INNER JOIN clinic_worker AS clin " +
                "INNER JOIN patient_register AS regi " +
                "ON subc.arra_id = arra.arra_id AND arra.clin_id = arra.clin_id AND subc.pati_id = pati.pati_id AND arra.clin_id = clin.clin_id AND regi.subc_id = subc.subc_id and regi.subc_id = ?";
        PatientRegister patientRegister = MySqlDBUtil.queryBean(sql,new Object[]{subcId},PatientRegister.class);
        return patientRegister;
    }
}
