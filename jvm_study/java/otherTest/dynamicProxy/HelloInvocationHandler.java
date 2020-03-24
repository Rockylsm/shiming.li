package otherTest.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shiming.li
 * @version $ v1.0 18-9-20 $
 */
public class HelloInvocationHandler implements InvocationHandler {
    private Object object;

    public HelloInvocationHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before helloInvocationHandler~~~~~~");
        Object invoke = method.invoke(object, args);
        System.out.println("after helloInvocationHandler~~~~~~");
        return invoke;
    }
}
