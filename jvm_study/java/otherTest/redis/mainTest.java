package otherTest.redis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;

/**
 * @author shiming.li
 * @version $ v1.0 19-3-25 $
 */
public class mainTest {
    private static final int THREAD_SIZ = 2;

    static Jedis jedis;
    static {
        try{
            jedis = new Jedis("127.0.0.1");
        }catch (Exception e){
            System.out.println("连接失败");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MockService mockService = new MockService();
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_SIZ);
        Thread[] threads = new Thread[THREAD_SIZ];
        for(int i =0; i < THREAD_SIZ; i++){

           Thread thread  = new Thread(() -> {
               try {
                   countDownLatch.await();
                   mockService.getAge("shiming.li", jedis);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           });
            threads[i] = thread;
            thread.start();
            countDownLatch.countDown();
        }

        Thread.sleep(300);
        jedis.quit();
    }
}
