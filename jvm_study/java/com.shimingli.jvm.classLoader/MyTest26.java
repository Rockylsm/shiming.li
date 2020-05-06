package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-5-6 $
 */

/*
    线程上下文类加载器的一般使用模式(获取 - 使用 - 还原)

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    try{
        Thread.currentThread().setContextClassLoader(targetTccl);
        myMethod();
    }catch{

    }finally{
        Thread.currentThread().setContextClassLoader(classLoader);
    }

    myMethod里面调用了Thread.currentThread().getContextClassLoader(),获取当前线程的上下文加载器去做某些事情.

    如果一个类由类加载器A加在, 那么这个类所依赖的类也是由相同的类加载器加载.(如果所依赖的类没有被加载过的话)

    ContextClassLoader就是为了破坏这种Java的类加载委托机制.

    当高层提供了统一的接口让低层去实现,同时又要在高层加载(或实例化)低层类时,就必须通过线程上下文加载器来帮助高层的classLoader
    找到并加载该类.
 */
public class MyTest26 {
}
