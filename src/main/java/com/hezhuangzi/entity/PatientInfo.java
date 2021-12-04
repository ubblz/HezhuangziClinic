package com.hezhuangzi.entity;

public class PatientInfo {
    private String patientId;
    private String phone;
    private String pwd;
    private Integer age;
    private String gen;
    private String icard;
    private String name;
    private String email;
    private Integer getInfo;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getIcard() {
        return icard;
    }

    public void setIcard(String icard) {
        this.icard = icard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getGetInfo() {
        return getInfo;
    }

    public void setGetInfo(Integer getInfo) {
        this.getInfo = getInfo;
    }
}
