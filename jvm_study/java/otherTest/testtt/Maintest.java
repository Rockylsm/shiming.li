package otherTest.testtt;

import java.lang.reflect.Proxy;

/**
 * @author shiming.li
 * @version $ v1.0 18-10-16 $
 */
public class Maintest {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        InterfaceInvocation invocation = new InterfaceInvocation(hello);
        Hello hello1 = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), invocation);
        hello1.sayHello("shiming.li");
    }
}
