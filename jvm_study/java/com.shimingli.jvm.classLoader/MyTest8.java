package com.shimingli.jvm.classLoader;

import java.util.Random;

/**
 *
 * 反编译看结果
 */
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest{
    public static final  int x = 3;
//    public static int y = 3;
//    public static final int z = new Random().nextInt(3);

    static {
        System.out.println("FinalTest static block");
    }
}
