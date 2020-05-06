package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-5-6 $
 */
/*
    当前类加载器(current ClassLoader)

    每个类都会使用自己的类加载器(即加载自身的类加载器)去加载其他类(指的是所依赖的类),
    如果classX依赖classY,那么classX的类加载器就会去加载classY(前提是classY尚未被加载)

    线程上下文加载器(context ClassLoader)

    线程上下文加载器是在JDK1.2开始引入的,类Tread中的getContextClassLoader() 与 setContextClassLoader(ClassLoader cl)
    分别用来获取和设置上下文加载器
    如果没有通过setContextClassLoader(ClassLoader cl)设置的话,线程将会继承父线程的上下文加载器.
    Java应用运行时的初始线程的上下文加载器是系统类加载器,在线程中运行的代码可以通过该类加载器来加载类和资源.

    线程上下文加在器的重要性:
    SPI(Service Provider Interface)

    父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classLoader来加载类.
    这就改变了父ClassLoader不能使用子classLoader或没有直接父子关系的ClassLoader加载的类的情况,
    即改变了 双亲委派模型

    线程上下文加载器就是当前线程的 Current ClassLoader

    在双亲委托模型下,类的加载是自下而上的,即下层类加载器会委托上层类加载器进行加载. 但对于SPI来说,有些接口是Java核心类库提供的,
    而Java核心类库是由启动类加载器加载的,而这些接口的实现却是来自不同的jar包(厂商提供), Java的启动类加载器是不会加载其他来源的jar包,
    这样传统的双亲委派模型就无法满足SPI的要求.而通过给当前线程设置上下文加载器,就可以由设置的上下文加载器来实现对于接口实现类的加载.
 */
public class MyTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
