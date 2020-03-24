package dynamicProxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author shiming.li
 * @version $ v1.0 18-9-20 $
 */
public class cglibDynamicProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SayHelloWorld.class);
        enhancer.setCallback(new MyMethodInterceptor());

        SayHelloWorld sayHelloWorld = (SayHelloWorld) enhancer.create();
        sayHelloWorld.sayHello();
    }
}
