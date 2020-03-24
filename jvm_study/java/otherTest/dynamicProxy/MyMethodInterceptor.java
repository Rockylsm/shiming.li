package otherTest.dynamicProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author shiming.li
 * @version $ v1.0 18-9-20 $
 */
public class MyMethodInterceptor implements MethodInterceptor{
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before MyMethodInterceptor~~~~");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("after MyMethodInterceptor~~~~");
        return invoke;
    }
}
