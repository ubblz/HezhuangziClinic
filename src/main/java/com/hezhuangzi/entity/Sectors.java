package com.hezhuangzi.entity;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sectors {

    private String sector;
    private List<DoctorPatient> doctorPatientList;


    public void setSector(String sector) {
        this.sector = sector;
    }

    public Sectors(){
        sector = "";
        //使用队列
        doctorPatientList = new ArrayList<>();
    }

    public String getSector() {
        return sector;
    }


    public List<DoctorPatient> getDoctorPatientList() {
        return doctorPatientList;
    }


    @Override
    public String toString() {
        return "Sectors{" +
                "sector='" + sector + '\'' +
                ", doctorPatientList=" + doctorPatientList +
                '}';
    }
}
