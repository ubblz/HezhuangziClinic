package com.hezhuangzi.entity;

import java.nio.channels.Pipe;
import java.util.Date;

public class ArragneDoctor {
    private Integer arrangeId;
    private String clinicId;
    private Integer subnum;
    private String ampm;
    private Date subdate;
    private String cname;
    private Integer age;
    private Date birth;
    private String phone;
    private String gen;
    private String post;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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
                ", cname='" + cname + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
