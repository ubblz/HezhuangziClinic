package com.hezhuangzi.entity;

import java.util.Date;

public class ClinicWorker {
    private String clinicId;
    private String cname;
    private String gen;
    private Date birth;
    private Integer age;
    private String post;
    private String phone;
    private String pic;
    private String typ;
    private String pwd;

    @Override
    public String toString() {
        return "ClinicWorker{" +
                "clinicId='" + clinicId + '\'' +
                ", gen='" + gen + '\'' +
                ", cname='" + cname + '\'' +
                ", birth=" + birth +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", pic='" + pic + '\'' +
                ", phone='" + phone + '\'' +
                ", typ='" + typ + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }


    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
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


    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
