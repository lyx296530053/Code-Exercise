package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class People01 implements Callable {
    int ticket=10;
    @Override
    public synchronized Object call() throws Exception {

        for (int i=0;i<3;i++) {
            System.out.println(Thread.currentThread().getName()+"还有"+ticket--+"张票");
            Thread.yield();
        }

        return "票卖完了下一次早点来。。";
    }
}
public class Test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task=new FutureTask(new People01());
        for (int i=0;i<10;i++) {
            new Thread(task).start();
        }
        System.out.println(task.get());
    }
}
