package ThreadTest;
class sync{
    public  void show(){
        synchronized (this) {
            System.out.println("开始线程为"+Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束线程为"+Thread.currentThread().getName());
        }
    }
}
class MyThread extends Thread{
    private sync s;

    public MyThread(sync s) {
        this.s=s;
    }
    @Override
    public void run() {
       s.show();
    }
}
public class Testsync{
    public static void main(String[] args) {
        sync s=new sync();
    for(int i=0;i<3;i++){
        new MyThread(s).start();
    }
    }
}
