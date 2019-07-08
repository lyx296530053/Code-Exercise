import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(1,20,2000,TimeUnit.
                MILLISECONDS,new LinkedBlockingQueue<Runnable>(10),new ThreadPoolExecutor.DiscardOldestPolicy());
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
       while(true) {
           pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"hello");
                }
            });
        }

    }
}
