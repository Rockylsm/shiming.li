package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-26 $
 */
public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by : " + this.getClass().getClassLoader());
    }
}
