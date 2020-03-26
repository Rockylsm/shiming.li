package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-26 $
 */
public class MySample {
    public MySample() {
        System.out.println("MySample is loaded by : "+ this.getClass().getClassLoader());

        new MyCat();
    }
}
