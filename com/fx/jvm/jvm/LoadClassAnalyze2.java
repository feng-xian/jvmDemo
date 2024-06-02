package com.fx.jvm.jvm;



public class LoadClassAnalyze2 {

    public static void main(String[] args) {
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println("appClassLoader:" + appClassLoader);
        System.out.println("extClassLoader:" + extClassLoader);
        System.out.println("bootstrapClassLoader:" + bootstrapClassLoader);


    }

}
