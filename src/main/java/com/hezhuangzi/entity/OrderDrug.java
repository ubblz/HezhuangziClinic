package com.hezhuangzi.entity;

public class OrderDrug {
    private Integer orderId;
    private Integer selectDrug;
    private String drugName;
    private Integer num;
    private double drugPrice;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSelectDrug() {
        return selectDrug;
    }

    public void setSelectDrug(Integer selectDrug) {
        this.selectDrug = selectDrug;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }

    @Override
    public String toString() {
        return "OrderDrug{" +
                "orderId=" + orderId +
                ", selectDrug=" + selectDrug +
                ", drugName='" + drugName + '\'' +
                ", num=" + num +
                ", drugPrice=" + drugPrice +
                '}';
    }
}
