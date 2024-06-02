package com.fx.jvm.jvm;

import java.io.FileInputStream;
import java.lang.String;


public class MyClassLoaderWithoutParent extends ClassLoader {


    private String classPath;

    public MyClassLoaderWithoutParent(String classPath) {
        this.classPath = classPath;
    }


    @Override
    protected Class<?> findClass(final String name)
            throws ClassNotFoundException {
        try {
            //1.读入指定路径的classPath下的类
            String path = name.replace('.', '/').concat(".class");
            FileInputStream fileInputStream = new FileInputStream(classPath + "/" + path);
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            fileInputStream.close();

            //2.加载该类
            return defineClass(name, data, 0, data.length);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {

                // If still not found, then invoke findClass in order
                // to find the class.
                long t1 = System.nanoTime();
                //对于Object类，使用父加载器
                if(!name.startsWith("com.qf.jvm")){
                    c = this.getParent().loadClass(name);
                }else{
                    c = findClass(name);
                }

                // this is the defining class loader; record the stats
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();

            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
}
