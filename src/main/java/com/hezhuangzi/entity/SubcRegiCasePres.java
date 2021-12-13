package com.hezhuangzi.entity;

import java.util.List;

public class SubcRegiCasePres {
    private PatientSubcribe patientSubcribe; //预约
    private PatientRegister patientRegister; //挂号单
    private PatientCaseHistory patientCaseHistory; //病历
    private PatientPrescription patientPrescription; //处方
    private List<OrderDrug> orderDrugList; //处方的药品

    public PatientSubcribe getPatientSubcribe() {
        return patientSubcribe;
    }

    public void setPatientSubcribe(PatientSubcribe patientSubcribe) {
        this.patientSubcribe = patientSubcribe;
    }

    public PatientRegister getPatientRegister() {
        return patientRegister;
    }

    public void setPatientRegister(PatientRegister patientRegister) {
        this.patientRegister = patientRegister;
    }

    public PatientCaseHistory getPatientCaseHistory() {
        return patientCaseHistory;
    }

    public void setPatientCaseHistory(PatientCaseHistory patientCaseHistory) {
        this.patientCaseHistory = patientCaseHistory;
    }

    public PatientPrescription getPatientPrescription() {
        return patientPrescription;
    }

    public void setPatientPrescription(PatientPrescription patientPrescription) {
        this.patientPrescription = patientPrescription;
    }

    public List<OrderDrug> getOrderDrugList() {
        return orderDrugList;
    }

    public void setOrderDrugList(List<OrderDrug> orderDrugList) {
        this.orderDrugList = orderDrugList;
    }

    @Override
    public String toString() {
        return "SubcRegiCasePres{" +
                "patientSubcribe=" + patientSubcribe +
                ", patientRegister=" + patientRegister +
                ", patientCaseHistory=" + patientCaseHistory +
                ", patientPrescription=" + patientPrescription +
                ", orderDrugList=" + orderDrugList +
                '}';
    }
}
