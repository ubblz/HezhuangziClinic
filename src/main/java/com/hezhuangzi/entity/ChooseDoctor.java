package com.hezhuangzi.entity;

import java.util.Date;

public class ChooseDoctor {
    private Integer arrangeId;
    private String clinicId;
    private String cname;
    private String gen;
    private Date birth;
    private Integer age;
    private String post;
    private String pic;
    private String phone;
    private String typ;
    private Integer amsubnum;
    private Integer pmsubnum;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Integer getAmsubnum() {
        return amsubnum;
    }

    public void setAmsubnum(Integer amsubnum) {
        this.amsubnum = amsubnum;
    }

    public Integer getPmsubnum() {
        return pmsubnum;
    }

    public void setPmsubnum(Integer pmsubnum) {
        this.pmsubnum = pmsubnum;
    }

    public Date getSubdate() {
        return subdate;
    }

    public void setSubdate(Date subdate) {
        this.subdate = subdate;
    }

    @Override
    public String toString() {
        return "ChooseDoctor{" +
                "arrangeId=" + arrangeId +
                ", clinicId='" + clinicId + '\'' +
                ", name='" + cname + '\'' +
                ", gen='" + gen + '\'' +
                ", birth=" + birth +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", pic='" + pic + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + typ + '\'' +
                ", amsubnum=" + amsubnum +
                ", pmsubnum=" + pmsubnum +
                ", subdate=" + subdate +
                '}';
    }
}
