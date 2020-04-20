package com.shimingli.jvm.classLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shiming.li
 * @version $ v1.0 20-4-20 $
 */

/**
 * 类加载器双亲委托模型的好处:
 * 1.可以确保java核心库的类型安全:所有的java应用都至少会引用java.lang.Object类,也就是说在运行期,java.lang.Object这个类会被
 * 加在到Java虚拟机中;如果这个加在过程是由Java应用自己的类加载器所完成的,那么很有可能就会在JVM中存在多个版本的java.lang.Object类,
 * 而且这些类之间还是不兼容的,相互不可见的(正是命名空间在发挥作用)
 *
 * 2.可以确保Java核心类库所提供的类不会被自定义的类所替代.
 *
 * 3.不同的类加载器可以为相同名称(binary name)的类创建额外的命名空间,相同名称的类可以并存在JVM中,只需要用不同的
 * 类加载器来加载他们即可.不同类加载器所加载的类之间是不兼容的,这就相当于在JVM内部创建了一个又一个相互隔离的java
 * 类空间,这类技术在很多框架中都得到了实际应用.
 */
public class MyTest20_21 {
    /**
     * 用MyTest16加在类(删除out中的.class, 放到/home/shimingli/com/shimingli/jvm/classLoader/  (在MyTest16设置的加在位置))
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> class1 = loader1.loadClass("com.shimingli.jvm.classLoader.MyPerson");
        Class<?> class2 = loader2.loadClass("com.shimingli.jvm.classLoader.MyPerson");


        System.out.println(class1 == class2);
        Object object1 = class1.newInstance();
        Object object2 = class2.newInstance();

        Method setPerson = class1.getMethod("setPerson", Object.class);
        setPerson.invoke(object1, object2);
    }
}
