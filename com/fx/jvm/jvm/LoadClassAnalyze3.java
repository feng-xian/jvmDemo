package com.fx.jvm.jvm;

import sun.misc.Launcher;


import java.net.URL;


public class LoadClassAnalyze3 {

    public static void main(String[] args) {
        //查看启动类加载器加载的内容：
        System.out.println("=====BootstrapClassLoader加载的内容=====");
        for (URL url : Launcher.getBootstrapClassPath().getURLs()) {
            System.out.println(url);
        }
        //查看extClassloader加载的内容：
        System.out.println("=====ExtClassLoader加载的内容=====");
        System.out.println(System.getProperty("java.ext.dirs"));
        //查看appClassloader加载的内容：
        System.out.println("=====appClassLoader加载的内容=====");
        System.out.println(System.getProperty("java.class.path"));
    }

}
