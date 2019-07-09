package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test08 {
    public static void main(String[] args) {
//        CountDownLatch countDownLatch=new CountDownLatch(1);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//                System.out.println(2);
//                countDownLatch.countDown();
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(4);
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(3);
//            }
//        }).start();
        FutureTask futureTask=new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return 3;
            }
        });
        Thread thread=new Thread(futureTask);
        thread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                System.out.println(2);
                try {
                    System.out.println(futureTask.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println(4);
            }
        }).start();
    }
}
