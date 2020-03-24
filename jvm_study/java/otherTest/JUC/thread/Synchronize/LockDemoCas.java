package otherTest.JUC.thread.Synchronize;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shiming.li
 * @version $ v1.0 19-2-25 $
 * J.U.JUC
 * 自旋 会比较耗内存
 * 会有ABA的问题 (版本号或计数器来解决)
 */
public class LockDemoCas {
    private volatile int NormalValue = 0;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int casInt = 0 ;
    private static Unsafe unsafe;

    static {
        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            unsafe = (Unsafe) unsafeField.get(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(){
        NormalValue ++ ;
    }

    private void atomicAdd(){
        atomicInteger.addAndGet(1);
    }

    private void casAdd() throws NoSuchFieldException {
        long offset;
        do{
            offset = unsafe.objectFieldOffset(LockDemoCas.class.getDeclaredField("casInt"));
        } while (!unsafe.compareAndSwapInt(this, offset, casInt, casInt + 1));
    }

    //期望value 为2000
    public static void main(String[] args) throws InterruptedException {
        LockDemoCas casForAdd = new LockDemoCas();
        for(int i = 0 ; i < 2; i++){
            new Thread(()->{
                for(int j = 0; j < 10000; j ++){
                    casForAdd.add();
                    casForAdd.atomicAdd();
                    try {
                        casForAdd.casAdd();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        Thread.sleep(2000);
        System.out.println("NormalValue is "  + casForAdd.NormalValue);
        System.out.println("atomicInteger is "  + casForAdd.atomicInteger);
        System.out.println("casInt is "  + casForAdd.casInt);
    }
}
