package com.shimingli.origin.test;

import com.shimingli.jvm.classLoader.MyTest16;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author shiming.li
 * @version $ v1.0 20-4-29 $
 */
public class ForNameTest {
    public static void main(String[] args) throws Exception{
        Constructor<?> aClass = Class.forName("com.shimingli.origin.test.MyCat").
                getDeclaredConstructor(new Class<?>[]{String.class});
        MyCat cat1 = (MyCat) aClass.newInstance(new Object[]{"wazi"});
        System.out.println(cat1);


        Class<?> clazz = Class.forName("com.shimingli.origin.test.MyCat", true, new MyTest16("testClassLoader"));
        Method setName = clazz.getDeclaredMethod("setName", new Class<?>[]{String.class});
        MyCat cat2 = (MyCat) clazz.newInstance();
        setName.invoke(cat2, "wazi");
        System.out.println(cat2.toString());
    }
}
