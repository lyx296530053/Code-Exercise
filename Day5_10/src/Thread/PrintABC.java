package Thread;

class Print {
    private int i = 1;

    public synchronized void a(int b) {
        if (i == 1) {
            i = 2;
            System.out.println(Thread.currentThread().getName() + b);
            notifyAll();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void b(int b) {
        if (i == 2) {
            i = 3;
            System.out.println(Thread.currentThread().getName() + b);
            notifyAll();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void c(int b) {
        if (i == 3) {
            i = 1;
            System.out.println(Thread.currentThread().getName() + b);
            notifyAll();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class PrintABC {
    public static void main(String[] args) {
        Print p = new Print();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    p.a(i);
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    p.b(i);
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    p.c(i);
                }
            }
        }, "C").start();
    }
}
