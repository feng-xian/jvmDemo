package com.fx.jvm.jvm;

import java.lang.reflect.Method;
import java.lang.String;


public class TestMyClassLoader {

    public static void main(String[] args) throws Exception {
        //1.创建自定义类加载器，指定加载路径
        MyClassLoader myClassLoader = new MyClassLoader("/Users/zeleishi/Documents/工作/授课/2104/第四阶段/myclass");
        //2.指定要加载的类名
        Class<?> clazz = myClassLoader.loadClass("com.qf.jvm.JVMAnalyze");
        //3.反射创建对象
        Object obj = clazz.newInstance();
        //4.创建add方法对象
        Method add = clazz.getDeclaredMethod("add", null);
        //5.调用对象的add方法
        Object result = add.invoke(obj);
        //6.打印结果
        System.out.println(result);
    }
}
