package com.hezhuangzi.entity;

import java.util.List;

public class DrugsOfPres {
    private PatientPrescription patientPrescription;
    private List<OrderDrug> orderDrugList;

    public DrugsOfPres(PatientPrescription patientPrescription, List<OrderDrug> orderDrugList) {
        this.patientPrescription = patientPrescription;
        this.orderDrugList = orderDrugList;
    }

    public List<OrderDrug> getOrderDrugList() {
        return orderDrugList;
    }

    public void setOrderDrugList(List<OrderDrug> orderDrugList) {
        this.orderDrugList = orderDrugList;
    }

    public PatientPrescription getPatientPrescription() {
        return patientPrescription;
    }

    public void setPatientPrescription(PatientPrescription patientPrescription) {
        this.patientPrescription = patientPrescription;
    }
}
