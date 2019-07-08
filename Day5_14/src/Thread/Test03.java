package Thread;

class Shop implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                if (ticket >= 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "还有" + ticket-- + "张票");
                }
            }
        }
    }
}

class Shop01 implements Runnable {
    private int ticket = 10;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.sell();
        }
    }
    synchronized void sell() {
        if (ticket >= 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "还有" + ticket-- + "张票");
        }
    }
}

public class Test03 {
    public static void main(String[] args) {
        Shop01 shop = new Shop01();
        new Thread(shop, "A").start();
        new Thread(shop, "B").start();
        new Thread(shop, "C").start();
    }
}
