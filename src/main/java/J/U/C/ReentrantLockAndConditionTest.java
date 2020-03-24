package J.U.C;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-16 $
 */
public class ReentrantLockAndConditionTest {
    /**
     * 两个线程循环输出1a2b3c4d.....
     */
    private static char[] aI = new char[]{'1','2','3','4','5','6'};
    private static char[] aC = new char[]{'A','B','C','D','E','F'};

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        new Thread(()->{
            lock.lock();
            try {
                for (char i : aI){
                    System.out.print(i);
                    condition2.signal();
                    condition1.await();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        new Thread(()->{
            lock.lock();
            try {
                for (char i : aI){
                    condition2.await();
                    System.out.print(i);
                    condition1.signal();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
    }
}
