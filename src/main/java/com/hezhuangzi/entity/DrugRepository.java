package com.hezhuangzi.entity;

public class DrugRepository {
    private Integer drug_id;
    private String drug_name;
    private double drug_price;
    private Integer drug_num;

    @Override
    public String toString() {
        return "DrugRepository{" +
                "drug_id=" + drug_id +
                ", drug_name='" + drug_name + '\'' +
                ", drug_price=" + drug_price +
                ", drug_num=" + drug_num +
                '}';
    }

    public Integer getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(Integer drug_id) {
        this.drug_id = drug_id;
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
}
