package com.mjtal.mongo_demo.util;

import java.sql.Connection;

public class Iodh {

    private Iodh(){
    }

    private static class HoderClass{
        private final static Connection connection = null;

        //  单例模式中的IoDH
        static{
            try {
                // connection = DriverManager.getConnection("","","");
            }catch (Exception e){
                e.printStackTrace();
            };

        }
    }

    private static Connection getInstance(){
        return HoderClass.connection;
    }
}
