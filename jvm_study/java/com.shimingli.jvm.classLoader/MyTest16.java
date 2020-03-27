package com.shimingli.jvm.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-26 $
 */
public class MyTest16 extends ClassLoader{
    private String className;

    private String classExt = ".class";

    private String path = "/home/shimingli/";

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        System.out.println("findClass invoked : "+ name);
        System.out.println("classLoader name : "+ this.getClassName());

        byte[] bytes = loadClassByMyTest16(name);
        return this.defineClass(name, bytes, 0, bytes.length);
    }

    public byte[] loadClassByMyTest16(String className){
        InputStream is = null;
        ByteArrayOutputStream os = null;
        byte[] result = null;
        try{
            className = className.replace(".", "/");
            is = new FileInputStream(new File(path + className + classExt));
            os = new ByteArrayOutputStream();
            int i = 0;
            while ((i = is.read()) != -1){
                os.write(i);
            }

            result = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 loader1 = new MyTest16("loader1");
        Class<?> clazz = loader1.loadClass("com.shimingli.jvm.classLoader.Mytest7");
        Object o = clazz.newInstance();
        System.out.println(o.getClass().getClassLoader());
    }
}
