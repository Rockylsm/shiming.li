package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-4-1 $
 *
 *
 * 用根类加载器加在一个类 ????????
 *
 */
public class MyTest18_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyTest16 loader = new MyTest16("loader1");

        loader.setPath("/home/shimingli/");

        Class<?> clazz = loader.loadClass("com.shimingli.jvm.classLoader.Mytest1");

        System.out.println("class : " + clazz.hashCode());
        System.out.println("classLoader : " + clazz.getClassLoader());
    }
}
