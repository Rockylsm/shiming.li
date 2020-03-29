package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-26 $
 */
public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by : " + this.getClass().getClassLoader());

        //每个类加载器都有自己的命名空间,命名空间由改加载器及所有父加载器所加载的类组成的
        //父加载器加载的类  是看不到  子加载器命名空间的类(子加载器加载的类)
        System.out.println("from MyCat : "+ MySample.class);
    }
}
