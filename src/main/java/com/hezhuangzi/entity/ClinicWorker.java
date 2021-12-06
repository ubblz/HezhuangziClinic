package com.hezhuangzi.entity;

import java.util.Date;

public class ClinicWorker {
    private String clinicId;
    private String name;
    private String gen;
    private Date birth;
    private Integer age;
    private String post;
    private String pic;
    private String phone;
    private String type;
    private String pwd;

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "ClinicWorker{" +
                "clinicId='" + clinicId + '\'' +
                ", name='" + name + '\'' +
                ", gen='" + gen + '\'' +
                ", birth=" + birth +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", pic='" + pic + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
