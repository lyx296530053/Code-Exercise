package cn.lyx.Sort;


class Sorts {
    public static void bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void insertSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        for (int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else break;
            }
            arr[j + 1] = value;
        }
    }

    public static void binartSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        int mid = 0, low, high;
        for (int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i - 1;
            low = 0;
            high = i - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (arr[mid] > value) {
                    high = mid - 1;
                } else low = mid + 1;
            }
            for (; j > high; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = value;
        }
    }

    public static void shellSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int step = arr.length / 2;
        while (step >= 1) {
            for (int i = step; i < arr.length; i++) {
                int value = arr[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (arr[j] > value) {
                        arr[j + step] = arr[j];
                    } else break;
                }
                arr[j + step] = value;
            }
            step = step / 2;
        }
    }

    public static void mergeSort(int[] arr, int low, int height) {
        if (low >= height) {
            return;
        }
        int q = (low + height) / 2;
        mergeSort(arr, low, q);
        mergeSort(arr, q + 1, height);
        merge(arr, low, q, height);
    }

    private static void merge(int[] arr, int low, int mid, int height) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[height - low + 1];
        while (i <= mid && j <= height) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else temp[k++] = arr[j++];
        }
        int start = i;
        int end = mid;
        if (j <= height) {
            start = j;
            end = height;
        }
        while (start <= end) {
            temp[k++] = arr[start++];
        }
        for (int l = 0; l < height - low + 1; l++) {
            arr[l + low] = temp[l];
        }
    }

    public static void selectSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public static void quickSort(int[] arr, int low, int height) {
        if (low >= height) {
            return;
        }
        int mid = doubleSign(arr, low, height);
        quickSort(arr, low, mid - 1);
        quickSort(arr, mid + 1, height);
    }

    private static int sign(int[] arr, int low, int height) {
        int index = (int) (Math.random() * (height - low + 1) + low);
        swap(arr, low, index);
        int value = arr[low];
        int j = low;
        for (int i = low + 1; i <= height; i++) {
            if (arr[i] < value) {
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static int doubleSign(int[] arr, int low, int height) {
        int index = (int) (Math.random() * (height - low + 1) + low);
        swap(arr, low, index);
        int value = arr[low];
        int i = low + 1;
        int j = height;
        while (true) {
            while (i <= height && arr[i] < value) i++;
            while (j >= low && arr[j] > value) j--;
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, low, j);
        return j;
    }

    public static void swap(int[] arr, int low, int height) {
        int temp = arr[low];
        arr[low] = arr[height];
        arr[height] = temp;
    }

    public static void heapSort(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else break;
        }
        arr[i] = temp;
    }

    public static int[] bucketSort(int[] arr, int max) {
        int[] arr1 = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            arr1[arr[i]] = arr[i];
        }
        return arr1;
    }
}

public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[10_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10_000_000);
        }

        Sorts sorts = new Sorts();
        long str = System.currentTimeMillis();
        // sorts.bubbleSort(arr);
        //sorts.insertSort(arr);
        // sorts.binartSort(arr);
        // sorts.shellSort(arr);
        // sorts.mergeSort(arr,0,arr.length-1);
        // sorts.selectSort(arr, arr.length-1);
        // sorts.quickSort(arr, 0, arr.length-1);
//        for (int i = arr.length/2-1; i >=0 ; i--) {
//            sorts.heapSort(arr,i,arr.length);
//        }
//        for (int i = arr.length-1; i >0 ; i--) {
//            sorts.swap(arr,0,i);
//            sorts.heapSort(arr,0,i);
//        }
        // int[] ints = sorts.bucketSort(arr, 10000000);
//        for (int i = 0; i < ints.length; i++) {
//            if(ints[i]>0){
//            }
//        }
        long end = System.currentTimeMillis();
        System.out.println(end - str);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
    }
}
