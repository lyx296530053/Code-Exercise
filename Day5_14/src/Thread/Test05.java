package Thread;
class Reentry {
    synchronized void A(){
        System.out.println("我是A");
        this.B();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized void B(){
        System.out.println("我是B");
    }
}
public class Test05 {
    public static void main(String[] args) {
        Reentry reentry=new Reentry();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                reentry.B();
            }
        });
        thread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentry.A();
            }
        }).start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
