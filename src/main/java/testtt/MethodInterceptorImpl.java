package testtt;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author shiming.li
 * @version $ v1.0 18-10-16 $
 */
public class MethodInterceptorImpl implements net.sf.cglib.proxy.MethodInterceptor{
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before intercept");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("after intercept");
        return o1;
    }
}
