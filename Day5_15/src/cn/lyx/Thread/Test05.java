package Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Temp extends RecursiveTask {
    private final int critical = 4;
    private int first;
    private int end;
    public Temp(int first, int end) {
        this.first = first;
        this.end = end;
    }
    @Override
    protected Object compute() {
        int result = 0;
        if (end - first <= 5) {
            for (int i = first; i <= end; i++) {
                result += i;
            }
        } else {
            int mid = (end - first) / 2 + first;
            Temp left = new Temp(first, mid);
            Temp right = new Temp(mid + 1, end);
            left.fork();
            right.fork();
            result = (Integer) left.join() + (Integer) right.join();
        }
        return result;
    }
}
public class Test05 {
    public static void main(String[] args) {
        Temp temp = new Temp(1, 10000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(temp);
        try {
            System.out.println(temp.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
