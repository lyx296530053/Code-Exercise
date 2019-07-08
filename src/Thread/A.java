package Thread;

/**
 * Created by lyx on 2019/4/14.
 */
class AA implements Runnable{
    int i=10;
    public void run(){
            while (i > 0) {
                System.out.println(Thread.currentThread().getName() + "第" + i-- + "次");
            }
    }
}
public class A {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main开始");
        AA aa=new AA();
        Thread thread=new Thread(aa,"one");
        Thread thread1=new Thread(aa,"two");
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000);
        thread1.start();
        System.out.println("main结束");

    }
}
