package otherTest.JUC.thread;

import com.google.common.base.Stopwatch;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shiming.li
 * @version $ v1.0 18-12-10 $
 */
public class ThreadMathCalculation {
    private static final ThreadPoolExecutor ex = new ThreadPoolExecutor(1, 10, 0, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());

    public static void calculation() throws InterruptedException {
//        final Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 2; i++){
            final int finalI = i;
            final Stopwatch stopwatch = Stopwatch.createStarted();
            ex.submit(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        semaphore.acquire();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("i = " + finalI +  " stopwatch" + stopwatch);
//                    Math.sin(Integer.MAX_VALUE);
//                    System.out.println("stopwatch" + stopwatch);
//                        semaphore.release();
                    try {
                        Thread.sleep(100000);
                        System.out.println("running");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("reset corePoolSize");
        ex.setCorePoolSize(2);
    }
}
