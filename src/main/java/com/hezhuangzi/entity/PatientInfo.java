package com.hezhuangzi.entity;

public class PatientInfo {

    private String pati_id;
    private String pati_phone;
    private Integer pati_age;
    private String pati_gen;
    private String pati_icard;
    private String pati_name;
    private String pati_email;
    private String pati_pwd;
    private Integer pati_getInfo;

    @Override
    public String toString() {
        return "PatientInfo{" +
                "pati_id='" + pati_id + '\'' +
                ", pati_phone='" + pati_phone + '\'' +
                ", pati_age=" + pati_age +
                ", pati_gen='" + pati_gen + '\'' +
                ", pati_icard='" + pati_icard + '\'' +
                ", pati_name='" + pati_name + '\'' +
                ", pati_email='" + pati_email + '\'' +
                ", pati_pwd='" + pati_pwd + '\'' +
                ", pati_getInfo=" + pati_getInfo +
                '}';
    }

    public String getPati_phone() {
        return pati_phone;
    }

    public void setPati_phone(String pati_phone) {
        this.pati_phone = pati_phone;
    }

    public String getPati_pwd() {
        return pati_pwd;
    }

    public void setPati_pwd(String pati_pwd) {
        this.pati_pwd = pati_pwd;
    }

    public Integer getPati_age() {
        return pati_age;
    }

    public void setPati_age(Integer pati_age) {
        this.pati_age = pati_age;
    }

    public String getPati_gen() {
        return pati_gen;
    }

    public void setPati_gen(String pati_gen) {
        this.pati_gen = pati_gen;
    }

    public String getPati_icard() {
        return pati_icard;
    }

    public void setPati_icard(String pati_icard) {
        this.pati_icard = pati_icard;
    }

    public String getPati_name() {
        return pati_name;
    }

    public void setPati_name(String pati_name) {
        this.pati_name = pati_name;
    }

    public String getPati_email() {
        return pati_email;
    }

    public void setPati_email(String pati_email) {
        this.pati_email = pati_email;
    }

    public Integer getPati_getInfo() {
        return pati_getInfo;
    }

    public void setPati_getInfo(Integer pati_getInfo) {
        this.pati_getInfo = pati_getInfo;
    }

    public String getPati_id() {
        return pati_id;
    }

    public void setPati_id(String pati_id) {
        this.pati_id = pati_id;
    }
}
