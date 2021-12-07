package com.hezhuangzi.entity;

import java.nio.channels.Pipe;
import java.util.Date;

public class ArragneDoctor {
    private Integer arrangeId;
    private String clinicId;
    private Integer subnum;
    private String ampm;
    private Date subdate;

    public Integer getArrangeId() {
        return arrangeId;
    }

    public void setArrangeId(Integer arrangeId) {
        this.arrangeId = arrangeId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public Integer getSubnum() {
        return subnum;
    }

    public void setSubnum(Integer subnum) {
        this.subnum = subnum;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public Date getSubdate() {
        return subdate;
    }

    public void setSubdate(Date subdate) {
        this.subdate = subdate;
    }

    @Override
    public String toString() {
        return "ArragneDoctor{" +
                "arrangeId=" + arrangeId +
                ", clinicId='" + clinicId + '\'' +
                ", subnum=" + subnum +
                ", ampm='" + ampm + '\'' +
                ", subdate=" + subdate +
                '}';
    }
}
