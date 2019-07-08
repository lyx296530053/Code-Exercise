package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl=new CountDownLatch(10);
        ExecutorService executorService=Executors.newCachedThreadPool(new ThreadFactory() {
            AtomicInteger atomicInteger=new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                Thread t=new Thread(r);
                t.setName(atomicInteger.getAndIncrement()+"");
                return t;
            }
        });
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    cdl.countDown();
                }
            });
        }
        cdl.await();
        System.out.println("程序结束");
        executorService.shutdown();
    }
}
