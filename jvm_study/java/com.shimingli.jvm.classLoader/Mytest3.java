package com.shimingli.jvm.classLoader;

import java.util.UUID;

/**
 * 编译期不能初始化的常量，不会被放至到调用方法所在类的常量池中。
 * 相当于主动调用常量提供的类，所以会初始化该类。
 */
public class Mytest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3{
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static code");
    }
}
