package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-4-20 $
 */
public class MyTest22 {
    static {
        System.out.println("MyTest22 initializer");
    }

    /**
     * 将MyTest22 通过 jar cvf test.jar MyTest22.class 打成jar包
     * 通过 java -Djava.ext.dirs=./ com.shimingli.jvm.classLoader.MyTest22 执行程序 输出
     *
     *  MyTest22 initializer
     sun.misc.Launcher$ExtClassLoader@73d16e93
     sun.misc.Launcher$AppClassLoader@73d16e93
     * 证明 Launcher$ExtClassLoader 加载 .jar 包中的class文件
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());

        System.out.println(Mytest1.class.getClassLoader());
    }
}
