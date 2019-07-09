package Thread;

import java.util.concurrent.*;


class  RunnableThread implements Runnable {
    private  int i = 0;
    @Override
    public void run() {
            while (i < 100) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
                i++;
            }
    }
}
    public class XianXingChi {

        public static void main(String[] args) {
            ExecutorService executorService = Executors.newFixedThreadPool(3);//定长
            ExecutorService executorService1 = Executors.newCachedThreadPool();//缓存
            ExecutorService executorService2 = Executors.newSingleThreadExecutor();//单例
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);//定时
            RunnableThread runnableThread = new RunnableThread();
            ThreadPoolExecutor threadPoolExecutor =
                    new ThreadPoolExecutor(3, 4, 2000, TimeUnit.MILLISECONDS,
                            new LinkedBlockingDeque<Runnable>());
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                }
            },2,3,TimeUnit.SECONDS);
//            for(int i=0;i<1000;i++){
//                threadPoolExecutor.execute(runnableThread);
//            }

        }
    }

