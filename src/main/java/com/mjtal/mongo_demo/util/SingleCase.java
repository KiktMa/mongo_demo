package com.mjtal.mongo_demo.util;

public class SingleCase {

    // 懒汉模式
    private SingleCase(){};
    private static SingleCase singleCase = null;

    public static SingleCase getSingleCase(){
        if(singleCase==null){
            singleCase = new SingleCase();
        }
        return singleCase;
    }

}
