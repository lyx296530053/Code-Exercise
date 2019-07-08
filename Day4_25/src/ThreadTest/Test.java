package ThreadTest;

public class Test {
    private static String customer;
    private static ThreadLocal threadLocal=new ThreadLocal();
    public static void main(String[] args) {
    customer="main";
    threadLocal.set("nihao");
    Thread thread=new Thread(new Runnable() {
        @Override
        public void run() {
            customer="hello";
            threadLocal.set("wobuhao");
            System.out.println(threadLocal.get());
        }
    });
    thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(customer);
        System.out.println(threadLocal.get());
    }
}
