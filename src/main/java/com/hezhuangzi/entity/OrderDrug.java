package com.hezhuangzi.entity;

public class OrderDrug {
    private Integer order_id;
    private Integer pres_id;
    private Integer drug_id;
    private Integer order_num;


    private String drug_name;
    private double drug_price;
    private Integer drug_num;



    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getPres_id() {
        return pres_id;
    }

    public void setPres_id(Integer pres_id) {
        this.pres_id = pres_id;
    }

    public Integer getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(Integer drug_id) {
        this.drug_id = drug_id;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public double getDrug_price() {
        return drug_price;
    }

    public void setDrug_price(double drug_price) {
        this.drug_price = drug_price;
    }

    public Integer getDrug_num() {
        return drug_num;
    }

    public void setDrug_num(Integer drug_num) {
        this.drug_num = drug_num;
    }

    @Override
    public String toString() {
        return "OrderDrug{" +
                "order_id=" + order_id +
                ", pres_id=" + pres_id +
                ", drug_id=" + drug_id +
                ", order_num=" + order_num +
                ", drug_name='" + drug_name + '\'' +
                ", drug_price=" + drug_price +
                ", drug_num=" + drug_num +
                '}';
    }
}
