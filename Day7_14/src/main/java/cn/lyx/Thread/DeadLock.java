package cn.lyx.Thread;
class A{}
class B{}
public class DeadLock {

    public static void main(String[] args) {
        final A a=new A();
        final B b=new B();
        Thread thread=new Thread(()->{
            synchronized (a.getClass()) {
                System.out.println("11111");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b.getClass()) {
                    System.out.println(44444);
                }
            }
        });
        Thread thread1=new Thread(()->{
            synchronized (b.getClass()) {
                System.out.println("222222");
                synchronized (a.getClass()) {
                    System.out.println(3333333);
                }
            }
        });
        thread.start();
        thread1.start();
    }
}
