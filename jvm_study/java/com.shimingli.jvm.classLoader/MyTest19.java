package com.shimingli.jvm.classLoader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @author shiming.li
 * @version $ v1.0 20-4-20 $
 */
public class MyTest19 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
