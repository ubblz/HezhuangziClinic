package com.hezhuangzi.test;

import com.hezhuangzi.util.MySqlDBUtil;
import com.hezhuangzi.util.OtherUtils;
import org.junit.Test;

import java.sql.SQLException;

public class DBTest {

    MySqlDBUtil dbUtil = new MySqlDBUtil();

    @Test
    public void dbTest() throws SQLException {
        String patientId = "p"+ OtherUtils.getCurrentTimeMillis();
        String sql = "INSERT INTO patient_info(pati_id,pati_phone,pati_pwd) VALUES(?,?,?)";
        Object[] params = {patientId,"13413092263","123"};
        int effect = dbUtil.insert(sql,params);
        System.out.println(effect);
    }
}
