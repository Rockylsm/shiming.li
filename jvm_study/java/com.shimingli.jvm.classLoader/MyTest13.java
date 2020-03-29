package com.shimingli.jvm.classLoader;

/**
     sun.misc.Launcher$AppClassLoader@18b4aac2
     sun.misc.Launcher$ExtClassLoader@1540e19d
     null
 */
public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);
        while (null != loader){
            loader = loader.getParent();
            System.out.println(loader);
        }
    }
}


