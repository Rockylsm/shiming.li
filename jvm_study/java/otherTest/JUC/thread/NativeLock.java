package otherTest.JUC.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author shiming.li
 * @version $ v1.0 19-2-25 $
 *
 * 手写reentrantLock
 */
public class NativeLock implements Lock{
    private AtomicReference<Thread> currentThread = new AtomicReference<>();
    private volatile int i = 0;

    private LinkedBlockingQueue<Thread> parkQueue = new LinkedBlockingQueue<>();
    @Override
    public void lock() {

        if(!currentThread.compareAndSet(null, Thread.currentThread())){
            //没有拿到锁
            try {
                parkQueue.put(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();  //停止线程

            //唤醒后移除
            parkQueue.remove(Thread.currentThread());
        }

        //拿到锁了 继续后续操作
    }

    @Override
    public void unlock() {
        if(currentThread.compareAndSet(Thread.currentThread(), null)){
            //释放锁 通知其他线程
            Object[] objects = parkQueue.toArray();
            for(Object o : objects){
                Thread thread = (Thread) o;
                LockSupport.unpark(thread);
            }
        }
        //不是当前线程获取的锁  不做操作
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
