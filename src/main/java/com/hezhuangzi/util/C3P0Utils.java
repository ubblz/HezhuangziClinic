package com.hezhuangzi.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.xml.crypto.Data;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Utils {
    private static final ComboPooledDataSource ds = new ComboPooledDataSource("mysql");

    private static ComboPooledDataSource getDataSource(){
        return ds;
    }

    public static QueryRunner getQueryRunner(){
        QueryRunner queryRunner = new QueryRunner(getDataSource());
        return  queryRunner;
    }

}
