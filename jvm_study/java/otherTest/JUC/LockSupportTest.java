package otherTest.JUC;

import java.util.concurrent.locks.LockSupport;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-16 $
 */
public class LockSupportTest {
    /**
     * 两个线程循环输出1a2b3c4d.....
     */
    private static char[] aI = new char[]{'1','2','3','4','5','6'};
    private static char[] aC = new char[]{'A','B','C','D','E','F'};
    static Thread t1, t2;
    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for(char i : aI){
                System.out.print(i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });


        t2 = new Thread(()->{
           for (char c : aC){
               LockSupport.park();
               System.out.print(c);
               LockSupport.unpark(t1);
           }
        });

        t1.start();
        t2.start();
    }
}
