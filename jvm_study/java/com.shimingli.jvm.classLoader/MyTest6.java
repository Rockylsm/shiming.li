package com.shimingli.jvm.classLoader;

public class MyTest6 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("counter1 : " + instance.counter1);
        System.out.println("counter2 : " + instance.counter2);
    }
}

/**
 * 会按照声明顺序从上往下做初始化
 */
class Singleton{
    public static int counter1;//准备1 + 解析 = 0
    private static Singleton singleton = new Singleton();//准备2

    private Singleton(){
        counter1++;//=1
        counter2++;//=1
        System.out.println("-------------");
        System.out.println(counter1);
        System.out.println(counter2);
        System.out.println("-------------");

    }

    public static int counter2 = 0;//准备 + 解析   =0

    public static Singleton getInstance(){
        return singleton;
    }
}
