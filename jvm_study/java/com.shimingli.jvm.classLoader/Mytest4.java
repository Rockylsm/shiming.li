package com.shimingli.jvm.classLoader;

/**
 * 对于数组实例来说，其类型是由jvm在运行期动态生成的，表示为[Lcom.shimingli.jvm.classLoader.MyParent4;这种形式
 * 动态生成的类型，其父类型就是Object。
 *
 * 对于数组来说，javaDoc经常将构成数组的元素为Component，实际上就是将数组降低一个维度后的类型
 *
 * 助记符：
 * anewarray: 表示创建一个引用类型的（如类、接口、数组）数组，并将其引用值压入栈顶
 * newarray: 表示创建一个指定的原始类型（如int、float、char等）的数组，并将其引用值压入栈顶
 */
public class Mytest4 {
    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();

        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        System.out.println("=======");

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());
        System.out.println(chars.getClass().getSuperclass());

        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());
        System.out.println(booleans.getClass().getSuperclass());

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());
        System.out.println(bytes.getClass().getSuperclass());

        short[] shorts = new short[1];
        System.out.println(shorts.getClass());
        System.out.println(shorts.getClass().getSuperclass());
    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static code");
    }
}
