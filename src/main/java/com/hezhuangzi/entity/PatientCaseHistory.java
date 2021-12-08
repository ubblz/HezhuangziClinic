package com.hezhuangzi.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PatientCaseHistory {
    private String csId;
    private String subcribeId;
    private String clinicId;
    private Date retime;
    private String hpi;

    private LocalDateTime createTime;

    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }

    public String getSubcribeId() {
        return subcribeId;
    }

    public void setSubcribeId(String subcribeId) {
        this.subcribeId = subcribeId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public Date getRetime() {
        return retime;
    }

    public void setRetime(Date retime) {
        this.retime = retime;
    }

    public String getHpi() {
        return hpi;
    }

    public void setHpi(String hpi) {
        this.hpi = hpi;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PatientCaseHistory{" +
                "csId='" + csId + '\'' +
                ", subcribeId='" + subcribeId + '\'' +
                ", clinicId='" + clinicId + '\'' +
                ", retime=" + retime +
                ", hpi='" + hpi + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
