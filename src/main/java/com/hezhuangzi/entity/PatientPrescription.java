package com.hezhuangzi.entity;


import java.lang.invoke.SwitchPoint;
import java.time.LocalDateTime;
import java.util.Date;

public class PatientPrescription {
    private String pres_id;
    private String regi_id;
    private String pres_diag;
    private Integer pres_pay;
    private Integer pres_choose;
    private Integer pres_finish;
    private LocalDateTime pres_createtime;

    private String subc_id;
    private String regi_clin_id;
    private LocalDateTime regi_createtime;
    private Integer regi_finish;

    private String pati_id; // info
    private String arra_id; // info
    private Integer subc_cancel;
    private Integer subc_break;
    private Integer subc_finish;
    private LocalDateTime subc_createtime;

    //pati info
    private String pati_phone;
    private Integer pati_age;
    private String pati_gen;
    private String pati_icard;
    private String pati_name;
    private String pati_email;
    private String pati_pwd;
    private Integer pati_getInfo;

    //arra info
    private int arra_subnum;
    private String arra_ampm;
    private Date arra_subdate;

    //clin info
    private String clin_id;
    private String clin_name;
    private String clin_gen;
    private Date clin_birth;
    private Integer clin_age;
    private String clin_post;
    private String clin_pic;

    @Override
    public String toString() {
        return "PatientPrescription{" +
                "pres_id='" + pres_id + '\'' +
                ", regi_id='" + regi_id + '\'' +
                ", pres_diag='" + pres_diag + '\'' +
                ", pres_pay=" + pres_pay +
                ", pres_choose=" + pres_choose +
                ", pres_finish=" + pres_finish +
                ", pres_createtime=" + pres_createtime +
                ", subc_id='" + subc_id + '\'' +
                ", regi_clin_id='" + regi_clin_id + '\'' +
                ", regi_createtime=" + regi_createtime +
                ", regi_finish=" + regi_finish +
                ", pati_id='" + pati_id + '\'' +
                ", arra_id='" + arra_id + '\'' +
                ", subc_cancel=" + subc_cancel +
                ", subc_break=" + subc_break +
                ", subc_finish=" + subc_finish +
                ", subc_createtime=" + subc_createtime +
                ", pati_phone='" + pati_phone + '\'' +
                ", pati_age=" + pati_age +
                ", pati_gen='" + pati_gen + '\'' +
                ", pati_icard='" + pati_icard + '\'' +
                ", pati_name='" + pati_name + '\'' +
                ", pati_email='" + pati_email + '\'' +
                ", pati_pwd='" + pati_pwd + '\'' +
                ", pati_getInfo=" + pati_getInfo +
                ", arra_subnum=" + arra_subnum +
                ", arra_ampm='" + arra_ampm + '\'' +
                ", arra_subdate=" + arra_subdate +
                ", clin_id='" + clin_id + '\'' +
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

    public String getPres_id() {
        return pres_id;
    }

    public void setPres_id(String pres_id) {
        this.pres_id = pres_id;
    }

    public String getRegi_id() {
        return regi_id;
    }

    public void setRegi_id(String regi_id) {
        this.regi_id = regi_id;
    }

    public String getPres_diag() {
        return pres_diag;
    }

    public void setPres_diag(String pres_diag) {
        this.pres_diag = pres_diag;
    }

    public Integer getPres_pay() {
        return pres_pay;
    }

    public void setPres_pay(Integer pres_pay) {
        this.pres_pay = pres_pay;
    }

    public Integer getPres_choose() {
        return pres_choose;
    }

    public void setPres_choose(Integer pres_choose) {
        this.pres_choose = pres_choose;
    }

    public Integer getPres_finish() {
        return pres_finish;
    }

    public void setPres_finish(Integer pres_finish) {
        this.pres_finish = pres_finish;
    }

    public LocalDateTime getPres_createtime() {
        return pres_createtime;
    }

    public void setPres_createtime(LocalDateTime pres_createtime) {
        this.pres_createtime = pres_createtime;
    }

    public String getSubc_id() {
        return subc_id;
    }

    public void setSubc_id(String subc_id) {
        this.subc_id = subc_id;
    }

    public String getRegi_clin_id() {
        return regi_clin_id;
    }

    public void setRegi_clin_id(String regi_clin_id) {
        this.regi_clin_id = regi_clin_id;
    }

    public LocalDateTime getRegi_createtime() {
        return regi_createtime;
    }

    public void setRegi_createtime(LocalDateTime regi_createtime) {
        this.regi_createtime = regi_createtime;
    }

    public Integer getRegi_finish() {
        return regi_finish;
    }

    public void setRegi_finish(Integer regi_finish) {
        this.regi_finish = regi_finish;
    }

    public String getPati_id() {
        return pati_id;
    }

    public void setPati_id(String pati_id) {
        this.pati_id = pati_id;
    }

    public String getArra_id() {
        return arra_id;
    }

    public void setArra_id(String arra_id) {
        this.arra_id = arra_id;
    }

    public Integer getSubc_cancel() {
        return subc_cancel;
    }

    public void setSubc_cancel(Integer subc_cancel) {
        this.subc_cancel = subc_cancel;
    }

    public Integer getSubc_break() {
        return subc_break;
    }

    public void setSubc_break(Integer subc_break) {
        this.subc_break = subc_break;
    }

    public Integer getSubc_finish() {
        return subc_finish;
    }

    public void setSubc_finish(Integer subc_finish) {
        this.subc_finish = subc_finish;
    }

    public LocalDateTime getSubc_createtime() {
        return subc_createtime;
    }

    public void setSubc_createtime(LocalDateTime subc_createtime) {
        this.subc_createtime = subc_createtime;
    }

    public String getPati_phone() {
        return pati_phone;
    }

    public void setPati_phone(String pati_phone) {
        this.pati_phone = pati_phone;
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

    public String getPati_pwd() {
        return pati_pwd;
    }

    public void setPati_pwd(String pati_pwd) {
        this.pati_pwd = pati_pwd;
    }

    public Integer getPati_getInfo() {
        return pati_getInfo;
    }

    public void setPati_getInfo(Integer pati_getInfo) {
        this.pati_getInfo = pati_getInfo;
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

    public String getClin_id() {
        return clin_id;
    }

    public void setClin_id(String clin_id) {
        this.clin_id = clin_id;
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

    private String clin_phone;
    private String clin_type;
    private String clin_pwd;

}
