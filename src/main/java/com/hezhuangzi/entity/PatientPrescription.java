package com.hezhuangzi.entity;


import java.lang.invoke.SwitchPoint;
import java.time.LocalDateTime;
import java.util.Date;

public class PatientPrescription {
    private String pres_id;
    private String regi_id;
    private String pres_diag;
    private Integer pres_pay;
    private Integer pres_choose;
    private Integer pres_finish;
    private LocalDateTime pres_createtime;

    // regi_id
    private String subc_id;
    private LocalDateTime regi_createtime;
    private Integer regi_finish;

    @Override
    public String toString() {
        return "PatientPrescription{" +
                "pres_id='" + pres_id + '\'' +
                ", regi_id='" + regi_id + '\'' +
                ", pres_diag='" + pres_diag + '\'' +
                ", pres_pay=" + pres_pay +
                ", pres_choose=" + pres_choose +
                ", pres_finish=" + pres_finish +
                ", pres_createtime=" + pres_createtime +
                ", subc_id='" + subc_id + '\'' +
                ", regi_createtime=" + regi_createtime +
                ", regi_finish=" + regi_finish +
                '}';
    }

    public String getPres_id() {
        return pres_id;
    }

    public void setPres_id(String pres_id) {
        this.pres_id = pres_id;
    }

    public String getRegi_id() {
        return regi_id;
    }

    public void setRegi_id(String regi_id) {
        this.regi_id = regi_id;
    }

    public String getPres_diag() {
        return pres_diag;
    }

    public void setPres_diag(String pres_diag) {
        this.pres_diag = pres_diag;
    }

    public Integer getPres_pay() {
        return pres_pay;
    }

    public void setPres_pay(Integer pres_pay) {
        this.pres_pay = pres_pay;
    }

    public Integer getPres_choose() {
        return pres_choose;
    }

    public void setPres_choose(Integer pres_choose) {
        this.pres_choose = pres_choose;
    }

    public Integer getPres_finish() {
        return pres_finish;
    }

    public void setPres_finish(Integer pres_finish) {
        this.pres_finish = pres_finish;
    }

    public LocalDateTime getPres_createtime() {
        return pres_createtime;
    }

    public void setPres_createtime(LocalDateTime pres_createtime) {
        this.pres_createtime = pres_createtime;
    }

    public String getSubc_id() {
        return subc_id;
    }

    public void setSubc_id(String subc_id) {
        this.subc_id = subc_id;
    }

    public LocalDateTime getRegi_createtime() {
        return regi_createtime;
    }

    public void setRegi_createtime(LocalDateTime regi_createtime) {
        this.regi_createtime = regi_createtime;
    }

    public Integer getRegi_finish() {
        return regi_finish;
    }

    public void setRegi_finish(Integer regi_finish) {
        this.regi_finish = regi_finish;
    }
}
