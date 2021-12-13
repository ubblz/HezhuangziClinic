package com.hezhuangzi.util;

import com.hezhuangzi.entity.OrderDrug;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.apache.poi.ss.formula.functions.T;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MySqlDBUtil {

//    private static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
//    private static final String DBNAME = "hzzDB";
//    private static final String JDBC_URI= "jdbc:mysql://localhost:3306/"+ DBNAME +"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//    private static final String USER = "root";
//    private static final String PWD = "hhrx";

//    private final int PORT = 3306;
//    private final String URI_PARAMS = "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//    private final String SERVER_NAME = "localhost";
//    private MysqlDataSource dataSource;

//    public MyDBUtil(){
////        dataSource = new MysqlDataSource();
////        dataSource.setDatabaseName(DBNAME);
////        dataSource.setUser(USER);
////        dataSource.setPassword(PWD);
////        dataSource.setServerName(SERVER_NAME);
////        dataSource.setPort(PORT);
////        dataSource.setURL(dataSource.getUrl()+URI_PARAMS);
//    }


//    private static Connection getConnection(){
//        DbUtils.loadDriver(JDBC_Driver);
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(JDBC_URI,USER,PWD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }


    public  static int insert(String sql) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        int effect = qr.execute(sql);
        return effect;
    }

    public static int insert(String sql,Object[] params) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        int effect = qr.execute(sql,params);
        return effect;
    }

    public static int update(String sql) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        int effect = qr.execute(sql);
        return effect;
    }

    public static int update(String sql,Object[] params) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        int effect = qr.execute(sql,params);
        return effect;
    }

    public static int delete(String sql) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        int effect = qr.execute(sql);
        return effect;
    }

    public static int delete(String sql,Object[] params) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        int effect = qr.execute(sql,params);
        return effect;
    }

    //Bean
    public static <T> T queryBean(String sql,Class<T> cls) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        T t = qr.query(sql,new BeanHandler<>(cls));
        return t;
    }

    //Bean
    public static <T> T queryBean(String sql,Object[] params,Class<T> cls) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        T t = qr.query(sql,params,new BeanHandler<>(cls));
        return t;
    }

    //BeanList
    public static <T> List<T> queryBeanList(String sql, Class<T> cls) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        List<T> t = qr.query(sql,new BeanListHandler<>(cls));
        return t;
    }

    //BeanList
    public static <T> List<T> queryBeanList(String sql,Object[] params,Class<T> cls) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        List<T> t = qr.query(sql,params,new BeanListHandler<>(cls));
        return t;
    }

    //scalar
    public static <T> T queryScalar(String sql) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        T t = qr.query(sql,new ScalarHandler<>());
        return t;
    }

    //mapList
    public static Map queryMap(String sql) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        Map t = qr.query(sql,new MapHandler());
        return t;
    }

    //mapList
    public static List queryMapList(String sql) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        List t = qr.query(sql,new MapListHandler());
        return t;
    }

    //mapList
    public static Map queryMap(String sql,Object[] params) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        Map t = qr.query(sql,params,new MapHandler());
        return t;
    }

    //mapList
    public static List queryMapList(String sql,Object[] params) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        List t = qr.query(sql,params,new MapListHandler());
        return t;
    }

    //scalar
    public static BigInteger insertGetId(String sql, Object[] p) throws SQLException {
        QueryRunner qr = C3P0Utils.getQueryRunner();
        BigInteger t = (BigInteger)qr.insert(sql,new ScalarHandler<>(),p);
        return t;
    }

}
