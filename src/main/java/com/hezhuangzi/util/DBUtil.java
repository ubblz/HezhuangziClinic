package com.hezhuangzi.util;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static String JDBC_Driver,DBNAME,JDBC_URI,USER,PWD;
    static{
        JDBC_Driver = "com.mysql.cj.jdbc.Driver";
        DBNAME = "hzzDB";
        JDBC_URI = "jdbc:mysql://localhost:3306/"+DBNAME+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        USER = "root";
        PWD = "hhrx";
    }

    public static Connection getConnection(){
        DbUtils.loadDriver(JDBC_Driver);
        Connection conn;
        try {
            conn = DriverManager.getConnection(JDBC_URI,USER,PWD);
        } catch (SQLException e) {
            conn = null;
            e.printStackTrace();
        }
        return conn;
    }



}
