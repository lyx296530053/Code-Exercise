package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Print01 {
    private int i = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printa() {
        lock.lock();
        try {
            if (i != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName());
            i = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printb() {
        lock.lock();
        try {
            if (i != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName());
            i = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printc() {
        lock.lock();
        try {
            if (i != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName());
            i = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class Test01 {
    public static void main(String[] args) {
        Print01 p = new Print01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    p.printa();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    p.printb();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    p.printc();
                }
            }
        }, "C").start();
    }
}
