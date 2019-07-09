package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Test02 {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
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
                    try {
                        semaphore.acquire();
                        System.out.println(semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                }
            });
            executorService.shutdown();
        }
    }
}
