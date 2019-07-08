package Thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test01 {
    public static void main(String[] args) {
        CyclicBarrier cb=new CyclicBarrier(10);
        ExecutorService executorService=Executors.newCachedThreadPool(new ThreadFactory() {
            AtomicInteger atomicInteger=new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                Thread t=new Thread(r);
                t.setName(atomicInteger.getAndIncrement()+"");
                return t;
            }
        });
        for (int i = 0; i <10; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}
