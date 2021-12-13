package com.hezhuangzi.entity;

import java.util.LinkedList;

public class DoctorPatient {

    private ClinicWorker doctor;


    public PatientRegister getPatienting() {
        return patienting;
    }

    public void setPatienting(PatientRegister patienting) {
        this.patienting = patienting;
    }

    private PatientRegister patienting;
    private LinkedList<PatientRegister> registerList;


    public LinkedList<PatientRegister> getRegisterList() {
        return registerList;
    }

    public void setRegisterList(LinkedList<PatientRegister> registerList) {
        this.registerList = registerList;
    }

    public DoctorPatient(ClinicWorker doctor, LinkedList<PatientRegister> registerList) {
        this.doctor = doctor;
        this.registerList = registerList;
    }

    public DoctorPatient() {
        doctor = null;
        registerList = new LinkedList<>();
    }

    public ClinicWorker getDoctor() {
        return doctor;
    }

    public void setDoctor(ClinicWorker doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "DoctorPatient{" +
                "doctor=" + doctor +
                ", patientList=" + registerList +
                '}';
    }
}
