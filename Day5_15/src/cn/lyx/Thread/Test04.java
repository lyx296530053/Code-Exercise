package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Product {
    BlockingQueue bq;
    public Product(BlockingQueue bq) {
        this.bq = bq;
    }
    void product() {
        try {
            bq.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产了一个商品");
    }
}
class Consume {
    BlockingQueue bq;
    public Consume(BlockingQueue bq) {
        this.bq = bq;
    }
    void consume() {
        try {
            bq.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费了一个商品");
    }
}

public class Test04 {
    public static void main(String[] args) {
        BlockingQueue bq = new ArrayBlockingQueue(5);
        Product product = new Product(bq);
        Consume consume = new Consume(bq);
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    product.product();
                }
            }).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    consume.consume();
                }
            }).start();
        }
    }
}
