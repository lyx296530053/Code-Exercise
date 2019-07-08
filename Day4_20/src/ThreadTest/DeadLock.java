package ThreadTest;

class pen{

}
class paper{

}
public class DeadLock {
    public static void main(String[] args) {
        pen p=new pen();
         paper pp=new paper();
    new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (p) {
                System.out.println("我有笔");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (pp) {
                    System.out.println("把你纸给我");
                }
            }
        }
    },"pen").start();
new Thread(new Runnable() {
    @Override
    public void run() {
        synchronized (pp) {
            System.out.println("我有纸");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (p) {
                System.out.println("把你笔给我");
            }
        }
    }
},"纸").start();
    }
}
