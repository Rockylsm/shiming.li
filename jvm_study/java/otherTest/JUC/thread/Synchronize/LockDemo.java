package otherTest.JUC.thread.Synchronize;

import otherTest.JUC.thread.NativeLock;

/**
 * @author shiming.li
 * @version $ v1.0 19-2-25 $
 */
public class LockDemo {

    int sycValue = 0;

    int nativeValue = 0;

    private NativeLock nativeLock = new NativeLock();


    private void sycAdd(){
        synchronized (this){
            sycValue ++ ;
        }
    }

    private void NativeLockAdd(){
        nativeLock.lock();
        nativeValue ++;
        nativeLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();
        for(int i = 0 ; i < 2; i++){
            new Thread(()->{
                for(int j = 0; j < 10000; j ++){
                    lockDemo.sycAdd();
                    lockDemo.NativeLockAdd();
                }
            }).start();
        }

        Thread.sleep(2000);
        System.out.println("sycValue is " + lockDemo.sycValue);
        System.out.println("nativeValue is " + lockDemo.nativeValue);
    }
}
