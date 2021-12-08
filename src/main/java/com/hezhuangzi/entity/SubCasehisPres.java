package com.hezhuangzi.entity;

import java.util.List;

public class SubCasehisPres {
    private PatientInfo patientInfo;
    private ClinicWorker doctorInfo;
    private PatientSubcribe patientSubcribe;
    private PatientCaseHistory patientCaseHistory;
    private PatientPrescription patientPrescription;
    private List<OrderDrug> orderDrugList;

    public OrderDrug[] getOrderDrugs() {
        return orderDrugs;
    }

    public void setOrderDrugs(OrderDrug[] orderDrugs) {
        this.orderDrugs = orderDrugs;
    }

    private OrderDrug[] orderDrugs;

    public SubCasehisPres() {
    }

    public SubCasehisPres(PatientInfo patientInfo, PatientCaseHistory patientCaseHistory, PatientPrescription patientPrescription, List<OrderDrug> orderDrugList) {
        this.patientInfo = patientInfo;
        this.patientCaseHistory = patientCaseHistory;
        this.patientPrescription = patientPrescription;
        this.orderDrugList = orderDrugList;
    }

    public SubCasehisPres(PatientInfo patientInfo, PatientSubcribe patientSubcribe, PatientCaseHistory patientCaseHistory, PatientPrescription patientPrescription, List<OrderDrug> orderDrugList) {
        this.patientInfo = patientInfo;
        this.patientSubcribe = patientSubcribe;
        this.patientCaseHistory = patientCaseHistory;
        this.patientPrescription = patientPrescription;
        this.orderDrugList = orderDrugList;
    }

    public SubCasehisPres(PatientInfo patientInfo, ClinicWorker doctorInfo, PatientSubcribe patientSubcribe, PatientCaseHistory patientCaseHistory, PatientPrescription patientPrescription, List<OrderDrug> orderDrugList) {
        this.patientInfo = patientInfo;
        this.doctorInfo = doctorInfo;
        this.patientSubcribe = patientSubcribe;
        this.patientCaseHistory = patientCaseHistory;
        this.patientPrescription = patientPrescription;
        this.orderDrugList = orderDrugList;
    }

    public SubCasehisPres(PatientInfo patientInfo, ClinicWorker doctorInfo, PatientSubcribe patientSubcribe, PatientCaseHistory patientCaseHistory, PatientPrescription patientPrescription, OrderDrug[] orderDrugs) {
        this.patientInfo = patientInfo;
        this.doctorInfo = doctorInfo;
        this.patientSubcribe = patientSubcribe;
        this.patientCaseHistory = patientCaseHistory;
        this.patientPrescription = patientPrescription;
        this.orderDrugs = orderDrugs;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
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
        return "SubCasehisPres{" +
                "patientInfo=" + patientInfo +
                ", patientCaseHistory=" + patientCaseHistory +
                ", patientPrescription=" + patientPrescription +
                ", orderDrugList=" + orderDrugList +
                '}';
    }

    public PatientSubcribe getPatientSubcribe() {
        return patientSubcribe;
    }

    public void setPatientSubcribe(PatientSubcribe patientSubcribe) {
        this.patientSubcribe = patientSubcribe;
    }

    public ClinicWorker getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(ClinicWorker doctorInfo) {
        this.doctorInfo = doctorInfo;
    }
}
