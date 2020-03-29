package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-26 $
 */
public class MySample {
    /**
     * 在自定义目录有MySample + MyCat的.class文件时以下三种情况
     * 1.不删除appclassLoader path下两个文件的 .class的时候, 可以正常输出, 两者都由应用类加载器加载
     * 2.删除appclassLoader path下MyCat.class ,会抛异常.   此时MySample由应用类加载器加载,MyCat会由 加载MySample的加载器尝试加载MyCat
     * 3.删除appclassLoader path下MySample.class文件,可正常运行,  MySample由自定义加载器加载, MyCat会由应用类加载器加载
     */
    public MySample() {
        System.out.println("MySample is loaded by : "+ this.getClass().getClassLoader());

        new MyCat();

        System.out.println("from MySample:"  + MyCat.class);
    }
}
