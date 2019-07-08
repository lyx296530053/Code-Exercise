package Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test04 {
    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch=new CountDownLatch(4);
//            new Thread(()->{
//                countDownLatch.countDown();
//                System.out.println(countDownLatch.getCount());
//            }).start();
//        countDownLatch.await();
//        System.out.println("gameover");
        CyclicBarrier cyclicBarrier=new CyclicBarrier(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println("1");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
            }).start();
        }
    }
}
