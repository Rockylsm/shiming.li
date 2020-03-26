package com.shimingli.jvm.classLoader;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-26 $
 */
public class MyTest16 extends ClassLoader{
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public MyTest16(String className){
        super();
        this.setClassName(className);
    }

    public MyTest16(ClassLoader classLoader, String className){
        super(classLoader);
        this.setClassName(className);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("find class name : "+ name);

        byte[] bytes = loadClassByMyTest16(name);
        return this.defineClass(name, bytes, 0, bytes.length);
    }

    public byte[] loadClassByMyTest16(String className){
        InputStream is = null;
        ByteOutputStream os = null;
        byte[] result = null;
        try{
            is = new FileInputStream(new File(className));
            os = new ByteOutputStream();
            int i = 0;
            while ((i = is.read()) != -1){
                os.write(i);
            }

            result = os.getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 loader1 = new MyTest16("loader1");
        Class<?> clazz = loader1.loadClass("home.shimingli/Mytest7.class");
        Object o = clazz.newInstance();
        System.out.println(o.getClass().getClassLoader());
    }
}
