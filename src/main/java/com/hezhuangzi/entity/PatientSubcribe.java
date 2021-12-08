package com.hezhuangzi.entity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PatientSubcribe {
    private String subcribeId;
    private String patientId;
    private String clinicId;
    private Date subTime;
    private String ampm;
    private Integer cancelSub;
    private String breakTime;
    private Integer finish;
    private LocalDateTime createTime;



    public String getSubcribeId() {
        return subcribeId;
    }

    public void setSubcribeId(String subcribeId) {
        this.subcribeId = subcribeId;
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

    public Date getSubTime() {
        return subTime;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public Integer getCancelSub() {
        return cancelSub;
    }

    public void setCancelSub(Integer cancelSub) {
        this.cancelSub = cancelSub;
    }

    public String getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(String breakTime) {
        this.breakTime = breakTime;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "PatientSubcribe{" +
                "subcribeId='" + subcribeId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", clinicId='" + clinicId + '\'' +
                ", subTime=" + subTime +
                ", ampm='" + ampm + '\'' +
                ", cancelSub=" + cancelSub +
                ", breakTime='" + breakTime + '\'' +
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
