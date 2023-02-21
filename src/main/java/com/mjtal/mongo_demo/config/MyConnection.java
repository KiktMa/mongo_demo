package com.mjtal.mongo_demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class MyConnection {
    @Value("${spring.datasource.driver-class-name}")
    static String driverClass;
    @Value("${spring.datasource.url}")
    static String url;
    @Value("${spring.datasource.username}")
    static String userName;
    @Value("${spring.datasource.password}")
    static String passWord;

    // 单例模式下连接postgresql数据库
    private static Connection con = null;
    public static Connection getCon() {
        if(MyConnection.con==null){
            initConnection();
        }
        return con;
    }

    @ConfigurationProperties("spring.datasource")
    private static void initConnection() {
        try {
            // java.sql.DriverManager.registerDriver (new org.postgresql.Driver());
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Couldn't find the driver!");
            cnfe.printStackTrace();
            System.exit(1);
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, passWord);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
