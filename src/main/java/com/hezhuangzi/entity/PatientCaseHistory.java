package com.hezhuangzi.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PatientCaseHistory {
    private Integer case_id;
    private String regi_id;

    public Date getCase_date() {
        return case_date;
    }

    public void setCase_date(Date case_date) {
        this.case_date = case_date;
    }

    private Date case_date;
    private String case_hpi;
    private LocalDateTime case_createtime;

    //regi info
    private String subc_id;
    private LocalDateTime regi_createtime;
    private Integer regi_finish;

    public Integer getCase_id() {
        return case_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    public String getRegi_id() {
        return regi_id;
    }

    public void setRegi_id(String regi_id) {
        this.regi_id = regi_id;
    }

    @Override
    public String toString() {
        return "PatientCaseHistory{" +
                "case_id=" + case_id +
                ", regi_id='" + regi_id + '\'' +
                ", case_date=" + case_date +
                ", case_hpi='" + case_hpi + '\'' +
                ", case_createtime=" + case_createtime +
                ", subc_id='" + subc_id + '\'' +
                ", regi_createtime=" + regi_createtime +
                ", regi_finish=" + regi_finish +
                '}';
    }

    public String getCase_hpi() {
        return case_hpi;
    }

    public void setCase_hpi(String case_hpi) {
        this.case_hpi = case_hpi;
    }

    public LocalDateTime getCase_createtime() {
        return case_createtime;
    }

    public void setCase_createtime(LocalDateTime case_createtime) {
        this.case_createtime = case_createtime;
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
