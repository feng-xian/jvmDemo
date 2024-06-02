package com.fx.jvm.jvm;

import java.io.FileInputStream;


public class MyClassLoader extends ClassLoader{


    private String classPath;

    public MyClassLoader(String classPath){
        this.classPath = classPath;
    }


    @Override
    protected Class<?> findClass(final String name)
            throws ClassNotFoundException
    {
        try {
            //1.读入指定路径的classPath下的类
            String path = name.replace('.', '/').concat(".class");
            FileInputStream fileInputStream = new FileInputStream(classPath+"/"+path);
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            fileInputStream.close();

            //2.加载该类
            return defineClass(name, data,0,data.length);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }
}
