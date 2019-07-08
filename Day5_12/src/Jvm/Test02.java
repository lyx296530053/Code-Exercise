package Jvm;

import java.util.concurrent.atomic.AtomicInteger;

class Temp {
    AtomicInteger a=new AtomicInteger();
    public void show() {
        a.getAndIncrement();
        System.out.println(Thread.currentThread().getName() + "----" + a);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test02 {
    public static void main(String[] args) {
        Temp temp = new Temp();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    temp.show();
                }
            }
        }, "01").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    temp.show();
                }
            }
        }, "02").start();
    }
}
