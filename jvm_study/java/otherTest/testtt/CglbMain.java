package otherTest.testtt;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author shiming.li
 * @version $ v1.0 18-10-16 $
 */
public class CglbMain {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SayHelloToYou.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        SayHelloToYou s = (SayHelloToYou) enhancer.create();
        s.say("shiming.li");
    }
}
