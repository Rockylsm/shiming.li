package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-4-27 $
 *   命名空间:
 *   在运行期一个java类是由该类的完全限定名(binary name,二进制名)和用于加在该类的定义类加载器(defining loader)所共同决定的.
 * 如果同样的名字(即相同的完全限定名)的类是由两个不同的加载器所加载,那么这些类就是不同的,即便.class文件的字节码完全一样,并且从相同的
 * 位置加载亦是如此.
 */

import sun.misc.Launcher;

/**
 * 在Oracle的Hotspot实现中,系统属性sun.boot.class.path如果修改错误,则运行会出错 提示如下错误:
 * NoClassDefFoundError : java/lang/Object
 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path")); //启动类加载器 加在.jar中的class文件
        System.out.println(System.getProperty("java.ext.dirs")); //加载 .jar 包中的class文件
        System.out.println(System.getProperty("java.class.path"));


        /**
         * 内建于jvm中的启动类加载器会加载java.lang.ClassLoader以及其他的java平台类.
         * 当JVM启动时,一块特殊的机器码会运行,它会加载加载扩展类加载器与系统类加载器.
         * 这块特殊的机器码叫做启动类加载器(BootStrap)
         *
         * 启动类加载器并不是java类,而其他的加载器则都是java类.
         * 启动类加载器是特定于平台的机器指令,他负责开启整个加载过程.
         *
         * 所有的类加载器(除了启动类加载器)都被实现为java类,不过,总归要有一个组件来加载第一个java类加载器,从而让整个加载过程能够顺利
         * 执行下去,加载第一个纯java类加载器就是启动类加载器的职责.
         *
         * 启动类加载器还会负责加在JRE正常运行所需要的基本组件,这包括java.util 和 java.lang包中的类等等.
         */

        System.out.println(ClassLoader.class.getClassLoader());//null 是由启动类加载器加载的
        //扩展类加载器和系统类加载器也是由启动类加载器加载的
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("----------------");

//        ClassLoader.getSystemClassLoader();
        //可以修改SystemClassLoader
        System.out.println(System.getProperty("java.system.class.loader"));
    }

}
