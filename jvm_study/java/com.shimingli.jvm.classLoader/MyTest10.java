package com.shimingli.jvm.classLoader;

/**
     MyTest10 static code
     =======
     Parent2 static code
     =======
     3
     =======
     Child2 static code
     4
 */
public class MyTest10 {
    static {
        System.out.println("MyTest10 static code");
    }

    public static void main(String[] args) { // Mytest10 的主动使用
        Parent2 parent2;  //仅声明类  不是类的主动使用
        System.out.println("=======");
        parent2 = new Parent2(); //生成一个类的实例   是对类的主动使用
        System.out.println("=======");
        System.out.println(parent2.a);//非首次主动使用   只输出a的值
        System.out.println("=======");
        System.out.println(Child2.b);//调用一个类的静态变量   是对类的主动使用   会是该类初始化（父类已经被初始化过，不会触发其他操作）
    }
}
class Parent2{
    static int a = 3;
    static {
        System.out.println("Parent2 static code");
    }
}

class Child2 extends Parent2{
    static int b = 4;
    static {
        System.out.println("Child2 static code");
    }
}
