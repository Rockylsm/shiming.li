package com.shimingli.jvm.classLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author shiming.li
 * 类加载器与instanceof关键字演示
 * @version $ v1.0 20-4-28 $
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.shimingli.jvm.classLoader.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.shimingli.jvm.classLoader.ClassLoaderTest);


        System.out.println(obj.getClass().getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader());
    }
}
