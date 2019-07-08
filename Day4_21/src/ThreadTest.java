class System1{
    private static final System1 s=new System1();
    private System1(){};
    public static System1 getS(){
        return s;
    }
    int i=10;
    public void get() {
        if(i>0) {
            System.out.println(Thread.currentThread().getName() + ":" + i--);
        }
    }
}
class Customer implements Runnable{
    @Override
    public void run() {
        while(true) {
            System1 system1 = System1.getS();
            synchronized (system1) {
                system1.get();
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        Customer customer=new Customer();
        for (int i = 0; i <3 ; i++) {
            new Thread(customer).start();
        }
    }
}
