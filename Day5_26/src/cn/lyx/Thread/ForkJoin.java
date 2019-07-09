package Thread;

import java.util.concurrent.RecursiveTask;

class MyCalcuater extends RecursiveTask {
    final int temp = 5;
    private int first;
    private int end;

    public MyCalcuater(int first, int end) {
        this.first = first;
        this.end = end;
    }

    @Override
    protected Object compute() {
        int result = 0;
        if (end - first < temp) {
            for (int i = first; i <= end; i++) {
                result += i;
            }
        } else {
            int mid = first + (end - first) / 2;
            MyCalcuater myCalcuater = new MyCalcuater(first, mid);
            MyCalcuater myCalcuater1 = new MyCalcuater(mid + 1, end);
            myCalcuater.fork();
            myCalcuater1.fork();
            result = (Integer) myCalcuater.join() + (Integer) myCalcuater1.join();
        }
        return result;
    }
}

public class ForkJoin {
    public static void main(String[] args) {
        MyCalcuater myCalcuater = new MyCalcuater(0, 100);
        System.out.println(myCalcuater.compute());
    }
}
