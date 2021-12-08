package com.hezhuangzi.entity;

import org.apache.poi.ss.formula.atp.Switch;

import java.lang.invoke.SwitchPoint;
import java.time.LocalDateTime;
import java.util.Date;

public class PatientPrescription {
    private  String presId;
    private String subscribeId;
    private String patientId;
    private String clinicId;
    private String diag;
    private Integer selectDrug;
    private Integer pay;
    private Integer choose;
    private Integer finish;
    private LocalDateTime createTime;

    public String getPresId() {
        return presId;
    }

    public void setPresId(String presId) {
        this.presId = presId;
    }

    public String getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(String subscribeId) {
        this.subscribeId = subscribeId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getDiag() {
        return diag;
    }

    public void setDiag(String diag) {
        this.diag = diag;
    }

    public Integer getSelectDrug() {
        return selectDrug;
    }

    public void setSelectDrug(Integer selectDrug) {
        this.selectDrug = selectDrug;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Integer getChoose() {
        return choose;
    }

    public void setChoose(Integer choose) {
        this.choose = choose;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "PatientPrescription{" +
                "presId='" + presId + '\'' +
                ", subscribeId='" + subscribeId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", clinicId='" + clinicId + '\'' +
                ", diag='" + diag + '\'' +
                ", selectDrug=" + selectDrug +
                ", pay=" + pay +
                ", choose=" + choose +
                ", finish=" + finish +
                ", createTime=" + createTime +
                '}';
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
