package otherTest.testtt;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shiming.li
 * @version $ v1.0 18-10-16 $
 */
public class InterfaceInvocation implements InvocationHandler{
    private Object object;

    public InterfaceInvocation(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object invoke = method.invoke(object, args);
        System.out.println("after invoke");
        return invoke;
    }
}
