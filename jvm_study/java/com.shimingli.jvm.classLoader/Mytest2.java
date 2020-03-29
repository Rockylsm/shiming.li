package com.shimingli.jvm.classLoader;

/**
 * 常量在编译阶段会存入到调用方法所在类的常量池中，本质上，调用类并没有直接引用到定义常量的累，因此并不会出发定义常量类的初始化
 * 注意：这里指的是将常量放到了Mytest2的常量池中，之后Mytest2与MyParent2就没有任何关系了，甚至，我们可以将MyParent2的class文件删除
 *
 */

/**
 * 助记符：
 * getstatic 从栈顶获取静态属性的值
 * putstatic 将静态属性值推送至栈顶
 * invokestatic 调用静态方法
 * ldc 表示将int float 或是string 类型的常量值从常量池推送至栈顶
 * bipush  表示将单字节（-128 - 127）的常量值推送至栈顶
 * sipush  表示将一个短整型常量值（-32768 - 32767）推送至栈顶
 * iconst_1 表示将int类型1推送至栈顶（iconst_m1 - iconst_5）  -1 - 5
 */
public class Mytest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.i);
    }
}

class MyParent2{
    public static final String str = "hello world";

    public static final short s = 127;

    public static final int i = 129;

    public static final int m = -1;

    static {
        System.out.println("MyParent static code");
    }
}
