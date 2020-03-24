package JVM;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-19 $
 */
public class Mytest7 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class c = Class.forName("JVM.C");
        System.out.println(c.getClassLoader());


        System.out.println(C.class.getCanonicalName());
        System.out.println(C.class.getName());
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> cClass = systemClassLoader.loadClass(C.class.getCanonicalName());
        Method hello1 = cClass.getDeclaredMethod("hello", new Class[0]);
        Method hello2 = cClass.getDeclaredMethod("hello", String.class);

        hello1.invoke(null, new Object[0]);
        hello2.invoke(new String(), "test");
    }
}

class C{
    public static void hello(){
        System.out.println("C say hello");
    }

    public static void hello(String msg){
        System.out.println("C say : "+ msg);
    }
}
