package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            int i = 0;
            @Override
            public Object call() throws Exception {
                for (int j = 0; j < 100; j++) {
                    i++;
                }
                return i;
            }
        });
        new Thread(futureTask).start();
        int value = (int) futureTask.get();
        System.out.println(value);
    }
}
