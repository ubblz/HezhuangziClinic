package com.hezhuangzi.test;

import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.services.clinic.ClinicService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ClinicQuery {
    @Test
    public void query(){
        ClinicDao dao = new ClinicDao();
        try {
            List<ClinicWorker> workers = dao.queryArrange("2021-12-9","erke","am");
            System.out.println(workers);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
