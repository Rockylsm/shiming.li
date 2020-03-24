package otherTest.JUC;

import java.util.concurrent.CountDownLatch;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-16 $
 */
public class WaitAndNotifyTest {
    /**
     * 两个线程循环输出1a2b3c4d.....
     */
    private static char[] aI = new char[]{'1','2','3','4','5','6'};
    private static char[] aC = new char[]{'A','B','C','D','E','F'};

    static final Object o = new Object();
    static final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            synchronized (o){
                for(char i : aI){
                    try {
                        System.out.print(i);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1").start();

        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o){
                    try {
                        for(char c : aC) {
                            System.out.print(c);
                            o.notify();
                            o.wait();
                        }
                        o.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }, "t2").start();
    }
}
