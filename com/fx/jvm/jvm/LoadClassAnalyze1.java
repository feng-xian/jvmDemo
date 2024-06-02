package com.fx.jvm.jvm;


import com.sun.java.accessibility.util.EventID;



public class LoadClassAnalyze1 {

    public static int count = 10;
    public static final int number = 20;
    public static LoadClassAnalyze1 loadClassAnalyze = new LoadClassAnalyze1();

    public static void main(String[] args) {
        ClassLoader classLoader1 = Object.class.getClassLoader();
        ClassLoader classLoader2 = EventID.class.getClassLoader();
        ClassLoader classLoader3 = LoadClassAnalyze1.class.getClassLoader();
        System.out.println("classLoader1:" + classLoader1);
        System.out.println("classLoader2:" + classLoader2);
        System.out.println("classLoader3:" + classLoader3);
    }


}
