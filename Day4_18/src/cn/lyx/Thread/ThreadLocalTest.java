package Thread;

public class ThreadLocalTest {
    private static String commStr;
    private static ThreadLocal threadStr = new ThreadLocal();
    public static void main(String[] args) {

        commStr = "main";
        threadStr.set("main");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                commStr = "thread";
                threadStr.set("thread");
            }
        });
        thread.start();

        System.out.println(commStr);
        System.out.println(threadStr.get());
    }
}
