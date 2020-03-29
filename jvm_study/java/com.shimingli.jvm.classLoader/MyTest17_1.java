package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-27 $
 *
 *
 * 关于命名空间的重要说明
 *  1.子加载器所加载的类能够访问父加载器所加载的类
 *  2.父加载器所加载的无法访问到子加在器所加载的类
 */
public class MyTest17_1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/home/shimingli/");

        Class<?> clazz = loader1.loadClass("com.shimingli.jvm.classLoader.MySample");
        System.out.println("class :" + clazz.hashCode());

        //如果注释掉该行,那么并不会实例化MySample对象,即MySample构造方法并不会被调用
        //因此不会实例化MyCat对象,即没有对MyCat的主动使用,这里就不会加载MyCat.class
        Object object = clazz.newInstance();
    }
}
