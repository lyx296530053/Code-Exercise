package Thread;
class People implements Runnable{
    private boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while(flag){
            try {
                boolean bool=Thread.currentThread().isInterrupted();
                if(bool){
                    System.out.println("非阻塞");
                    break;
                }
                Thread.sleep(0);
                System.out.println(i++);
            } catch (InterruptedException e) {
                boolean bool=Thread.currentThread().isInterrupted();
                System.out.println(bool+"阻塞");
                return;
            }
        }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
public class Test {
    static boolean flag=false;
    public static void main(String[] args) throws InterruptedException {
//        People people=new People();
//       Thread thread=new Thread(people);
//       thread.start();
//       Thread.sleep(2000);
//       thread.interrupt();
//        System.out.println("代码结束");
//        new Thread(()->{
//            while(!flag){
//                System.out.println("start...");
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("结束线程");
//        }).start();
//        Thread.sleep(2000);
//        flag=true;
//        System.out.println("程序退出");
        Thread thread=new Thread(()->{
            int i=1;
            while(true){
                try {
                    boolean bool=Thread.currentThread().isInterrupted();
                    if(bool){
                        System.out.println("非阻塞");
                        break;
                    }
                    Thread.sleep(100);
                    System.out.println(i++);
                } catch (InterruptedException e) {
                    boolean bool=Thread.currentThread().isInterrupted();
                    System.out.println(bool+"阻塞");
                    return;
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("程序退出");
    }
}
