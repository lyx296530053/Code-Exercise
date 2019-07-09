package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

class ProducerConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

   static class Producer1 extends Thread {
        @Override
        public void run() {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("produce..");
        }
    }

 static class Consumer1 extends Thread {

        @Override
        public void run() {
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consume..");
        }
    }
}

public class BlockingQueueTest {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(()->{
//                try {
//                    blockingQueue.put(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("生产了一个");
//            });
//        }
//        for (int i = 0; i < 4; i++) {
//            executorService.execute(()->{
//                try {
//                    blockingQueue.take();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("消费了一个");
//            });
        for (int i = 0; i < 2; i++) {
            ProducerConsumer.Producer1 producer1=new ProducerConsumer.Producer1();
            producer1.start();
        }
        for (int i = 0; i < 5; i++) {
            ProducerConsumer.Consumer1 consumer = new ProducerConsumer.Consumer1();
            consumer.start();
        }
    }
}
