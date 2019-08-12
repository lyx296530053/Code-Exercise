package cn.lyx.Sorts;

import javax.xml.ws.Response;

public class SortTest {
    public static void bubbleSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        boolean flag = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void selectSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public static void insertSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int value = arr[i];
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else break;
            }
            arr[j + 1] = value;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else temp[k++] = arr[j++];
        }
        int start = i;
        int end = mid;
        if (right >= j) {
            start = j;
            end = right;
        }
        while (start <= end) {
            temp[k++] = arr[start++];
        }
        for (int l = 0; l <= right - left; l++) {
            arr[l + left] = temp[l];
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int addMin(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        return mergeMin(arr, 0, arr.length - 1);
    }

    private static int mergeMin(int[] arr, int low, int height) {
        if (low >= height) {
            return 0;
        }
        int mid = low + (height - low) / 2;
        return mergeMin(arr, low, mid) + mergeMin(arr, mid + 1, height) + mergeAdd(arr, low, mid, height);
    }

    private static int mergeAdd(int[] arr, int low, int mid, int height) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int add = 0;
        int[] temp = new int[height - low + 1];
        while (i <= mid && j <= height) {
            add += arr[i] > arr[j] ? 0 : (height - j + 1) * arr[i];
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else temp[k++] = arr[j++];
        }
        int start = i;
        int end = mid;
        if (height >= j) {
            start = j;
            end = height;
        }
        while (start <= end) {
            temp[k++] = arr[start++];
        }
        for (int l = 0; l <= height - low; l++) {
            arr[l + low] = temp[l];
        }

        return add;
    }


    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(arr, left, (int) (Math.random() * (right - left + 1) + left));
        int value = arr[left];
        int lt = left;
        int i = left + 1;
        int gt = right + 1;
        while (i < gt) {
            if (arr[i] > value) {
                swap(arr, i, gt - 1);
                gt--;
            } else if (arr[i] < value) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else i++;
        }
        swap(arr, left, lt);
        quickSort(arr, left, lt);
        quickSort(arr, gt, right);
    }

    public static void heapSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        for (int i : arr) {
            System.out.print(i + " ");

        }
        System.out.println();
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int temp = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            temp = arr[index] > arr[temp] ? index : temp;
            if (temp == index) {
                break;
            }
            swap(arr, temp, index);
            index = temp;
            left = index * 2 + 1;
        }
    }

    public static int maxDifference(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        if (max == min) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int mins[] = new int[len + 1];
        int maxs[] = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] arr = {51, 33, 60, 24, 53, 34, 89, 77, 83, 73};

        //bubbleSort(arr);
        //selectSort(arr, 10);
        //insertSort(arr);
        //mergeSort(arr, 0, 9);
        //int i1 = addMin(new int[]{1,3,4,2,5});
        //System.out.println(i1);
        //quickSort(arr, 0, 9);
//        heapSort(arr);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        int i = maxDifference(arr);
        System.out.println(i);
    }
}
