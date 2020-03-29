package com.shimingli.jvm.classLoader;

/**
 * 子类和父类的关系
 *
 */
public class MyTest9 {

    static {
        System.out.println("MyTest9 static code");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}

class Parent{
    static int a = 3;
    static {
        System.out.println("Parent static code");
    }
}

class Child extends Parent{
    static int b = 4;

    static {
        System.out.println("Child static code");
    }
}
