package com.shimingli.jvm.classLoader;

/**
     Parent3 static code
     3
     -----------
     do some thing
 */
public class MyTest11 {
    public static void main(String[] args) {
        //变量属于谁  会初始化谁
        System.out.println(Child3.a);//对于父类的主动使用 触发父类的初始化
        System.out.println("-----------");
        Child3.doSomething();//对父类的主动使用
    }
}
class Parent3{
    static int a = 3;
    static {
        System.out.println("Parent3 static code");
    }

    static void doSomething(){
        System.out.println("do some thing");
    }
}
class Child3 extends Parent3{
    static {
        System.out.println("Child3 static code");//不会打印，此处静态变量不属于它，属于它的父类
    }
}
