package ThreadTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0,Integer.MAX_VALUE,1000
//                ,TimeUnit.MILLISECONDS,new LinkedBlockingQueue(1));
//        for(int i=0;i<1000;i++){
//            threadPoolExecutor.execute(new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName()+"我在学习你呢？");
//                    }
//            }));
//        }
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        while(true){
//            executorService.execute(new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName()+"hello world");
//                }
//            }));
//        }
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        while(true){
//            executorService.execute(new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName()+"hello world");
//                }
//            }));
//        }
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        while(true){
//            executorService.execute(new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName()+"hello world");
//                }
//            }));
//        }
        ScheduledExecutorService executorService =
                Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName()+"、"+j);
                    }
                }
            },10,3,TimeUnit.SECONDS);
        }
    }
}
