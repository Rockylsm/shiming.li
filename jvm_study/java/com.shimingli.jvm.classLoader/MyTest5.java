package com.shimingli.jvm.classLoader;

/**
 * 接口中的变量都是用  public static final 修饰的
 * 会被放到调用方法的类的常量池
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);

        System.out.println("------");
        System.out.println(MyChild5_I.thread);
    }
}
class MyCrandpa{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyGrandpa invoked");
        }
    };
}

class MyParent5 extends MyCrandpa{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5 invoked");
        }
    };
}

class MyChild5 extends MyParent5{
    public static int b = 5;
}
interface MyParent5_I{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5_I invoked");
        }
    };
}

interface MyChild5_I extends MyParent5_I{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyChild5_I invoked");
        }
    };
}