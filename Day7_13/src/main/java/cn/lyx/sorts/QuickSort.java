package cn.lyx.sorts;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = doubleSign(arr, low, high);
        quickSort(arr, low, q - 1);
        quickSort(arr, q + 1, high);
    }

    private static int sign(int[] arr, int low, int high) {
        int value = arr[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < value) {
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static int doubleSign(int[] arr, int low, int high) {
        int value = arr[low];
        int i = low + 1;
        int j = high;
        while (true) {
            while (i <= high && arr[i] < value) {
                i++;
            }
            while (j >= low && arr[j] > value) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, low, j);
        return j;
    }

    private static void threeSign(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int value = arr[low];
        int i = low + 1;
        int gt = high + 1;
        int lt = low;
        while (i < gt) {

            if (arr[i] < value) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i] > value) {
                swap(arr, i, gt - 1);
                gt--;
            } else
                i++;
        }
        swap(arr, low, lt);
        threeSign(arr, low, lt);
        threeSign(arr, gt, high);
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 2, 6, 3, 7, 3};
        threeSign(arr, 0, 8);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
