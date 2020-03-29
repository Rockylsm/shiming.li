package com.shimingli.jvm.classLoader;
//调用ClassLoader类的loadClass加载一个类，并不是对类的主动使用，不会导致类的初始化
public class Mytest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.shimingli.jvm.classLoader.CL");
        System.out.println("======");
        System.out.println(clazz);
        System.out.println("======");
        clazz = Class.forName("com.shimingli.jvm.classLoader.CL");//反射 表示对类的主动使用
        System.out.println(clazz);
    }
}

class CL{
    static {
        System.out.println("class CL");
    }
}
