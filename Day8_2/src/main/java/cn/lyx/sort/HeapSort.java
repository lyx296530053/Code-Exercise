package cn.lyx.sort;

import org.junit.Test;

import java.util.Arrays;

public class HeapSort {
    @Test
    public void test() {
        int arr[]=new int[160_000_000];
        for (int i = 0; i < 160_000_000; i++) {
            arr[i]=(int) (Math.random()*160_000_000);
        }
        long l = System.currentTimeMillis();
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            adjustHeap(arr, i, arr.length);
//        }
//        for (int i = arr.length - 1; i > 0; i--) {
//            int temp = arr[i];
//            arr[i] = arr[0];
//            arr[0] = temp;
//            adjustHeap(arr, 0, i);
//        }
        Arrays.sort(arr);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }

    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (temp < arr[j]) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
