package Thread;

public class Test04 {
    public static void main(String[] args) {
        Test04 test04=new Test04();
        Test04 test041=new Test04();
        new Thread(()->{
            synchronized (test04) {
                test04.A();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (test041) {
                    test041.A();
                }
            }
        }).start();
        new Thread(()->{
            synchronized (test041) {
                test041.A();
                synchronized (test04) {
                    test04.A();
                }
            }
        }).start();
    }
  public  void A(){
        System.out.println("我是A");
    }
}
