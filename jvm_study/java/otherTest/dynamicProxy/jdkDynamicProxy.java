package otherTest.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author shiming.li
 * @version $ v1.0 18-9-20 $
 */
public class jdkDynamicProxy {
    public static void main(String[] args) {
        Hello hello = new Hello();
        HelloInvocationHandler handler = new HelloInvocationHandler(hello);
        HelloInterface helloInterface = (HelloInterface) Proxy.newProxyInstance
                (Hello.class.getClassLoader(), Hello.class.getInterfaces(), handler);
        helloInterface.sayHello();
    }
}

