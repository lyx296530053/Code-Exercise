package Sort;

import java.util.Random;
import java.util.stream.Stream;

class Sorts {
    public static void bubbleSort(int[] arr) {
        if (arr.length <= 1) return;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        int[] arr = Test.getArr(10, 10, 100);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        Sorts.bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    public static int[] getArr(int n, int left, int right) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((new Random().nextInt(right - left + 1) + right));
        }
        return arr;
    }
}
