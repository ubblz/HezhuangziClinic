package com.hezhuangzi.entity;

import java.util.Date;

public class ArrangeDoctor {
    private Integer arra_id;
    private String clin_id;
    private int arra_subnum;
    private String arra_ampm;
    private Date arra_subdate;


    //添加clin_id的所有信息
    private String clin_name;
    private String clin_gen;
    private Date clin_birth;
    private Integer clin_age;
    private String clin_post;
    private String clin_pic;
    private String clin_phone;
    private String clin_type;
    private String clin_pwd;

    @Override
    public String toString() {
        return "ArragneDoctor{" +
                "arra_id=" + arra_id +
                ", clin_id='" + clin_id + '\'' +
                ", arra_subnum=" + arra_subnum +
                ", arra_ampm='" + arra_ampm + '\'' +
                ", arra_subdate=" + arra_subdate +
                ", clin_name='" + clin_name + '\'' +
                ", clin_gen='" + clin_gen + '\'' +
                ", clin_birth=" + clin_birth +
                ", clin_age=" + clin_age +
                ", clin_post='" + clin_post + '\'' +
                ", clin_pic='" + clin_pic + '\'' +
                ", clin_phone='" + clin_phone + '\'' +
                ", clin_type='" + clin_type + '\'' +
                ", clin_pwd='" + clin_pwd + '\'' +
                '}';
    }


    public Integer getArra_id() {
        return arra_id;
    }

    public void setArra_id(Integer arra_id) {
        this.arra_id = arra_id;
    }

    public String getClin_id() {
        return clin_id;
    }

    public void setClin_id(String clin_id) {
        this.clin_id = clin_id;
    }

    public int getArra_subnum() {
        return arra_subnum;
    }

    public void setArra_subnum(int arra_subnum) {
        this.arra_subnum = arra_subnum;
    }

    public String getArra_ampm() {
        return arra_ampm;
    }

    public void setArra_ampm(String arra_ampm) {
        this.arra_ampm = arra_ampm;
    }

    public Date getArra_subdate() {
        return arra_subdate;
    }

    public void setArra_subdate(Date arra_subdate) {
        this.arra_subdate = arra_subdate;
    }

    public String getClin_name() {
        return clin_name;
    }

    public void setClin_name(String clin_name) {
        this.clin_name = clin_name;
    }

    public String getClin_gen() {
        return clin_gen;
    }

    public void setClin_gen(String clin_gen) {
        this.clin_gen = clin_gen;
    }

    public Date getClin_birth() {
        return clin_birth;
    }

    public void setClin_birth(Date clin_birth) {
        this.clin_birth = clin_birth;
    }

    public Integer getClin_age() {
        return clin_age;
    }

    public void setClin_age(Integer clin_age) {
        this.clin_age = clin_age;
    }

    public String getClin_post() {
        return clin_post;
    }

    public void setClin_post(String clin_post) {
        this.clin_post = clin_post;
    }

    public String getClin_pic() {
        return clin_pic;
    }

    public void setClin_pic(String clin_pic) {
        this.clin_pic = clin_pic;
    }

    public String getClin_phone() {
        return clin_phone;
    }

    public void setClin_phone(String clin_phone) {
        this.clin_phone = clin_phone;
    }

    public String getClin_type() {
        return clin_type;
    }

    public void setClin_type(String clin_type) {
        this.clin_type = clin_type;
    }

    public String getClin_pwd() {
        return clin_pwd;
    }

    public void setClin_pwd(String clin_pwd) {
        this.clin_pwd = clin_pwd;
    }
}
