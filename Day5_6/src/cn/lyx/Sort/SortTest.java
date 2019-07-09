package Sort;

class Test {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else
                    break;
            }
            arr[j + 1] = temp;
        }
    }

    public static void binarySort(int[] arr) {
        int low, mid, hight;
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            low = 0;
            hight = i - 1;
            while (low <= hight) {
                mid = (low + hight) / 2;
                if (arr[mid] > temp) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (; j > hight; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;
        int steap = n / 2;
        while (steap >= 1) {
            for (int i = steap; i < n; i++) {
                int j = i - steap;
                int temp = arr[i];
                for (; j >= 0; j -= steap) {
                    if (arr[j] > temp) {
                        arr[j + steap] = arr[j];
                    } else break;
                }
                arr[j + steap] = temp;
            }
            steap = steap / 2;
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        int start = i;
        int end = mid;
        if (high >= j) {
            start = j;
            end = high;
        }
        while (start <= end) {
            temp[k++] = arr[start++];
        }
        for (i = 0; i <= high - low; i++) {
            arr[i + low] = temp[i];
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
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int q = doubleSign(arr, low, high);
        quickSort(arr, low, q - 1);
        quickSort(arr, q + 1, high);
    }

    public static int sign(int[] arr, int low, int high) {
        int value = arr[low];
        int j = low;
        int i = low + 1;
        for (; i <= high; i++) {
            if (arr[i] < value) {
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, low, j);
        return j;
    }

    public static int doubleSign(int[] arr, int low, int high) {
        int value = arr[low];
        int i = low + 1;
        int j = high;
        while (true) {
            while (arr[i] < value && i <= high) i++;
            while (arr[j] > value && j >= low) j--;
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

    public static void threeSign(int[] arr, int low, int high) {
        if (low >= high){
            return;
        }
        int value = arr[low];
        int i = low + 1;
        int gt = high + 1;
        int lt = low;
        while (i < gt) {
            if (arr[i] > value) {
                swap(arr, i, gt - 1);
                gt--;
            } else if (arr[i] < value) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else i++;
        }
        swap(arr, low, lt);
        threeSign(arr, low, lt);
        threeSign(arr, gt, high);
    }

    public static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}

public class SortTest {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 1, 9, 3, 5, 7, 10};
        //Test.bubbleSort(arr);
        //Test.insertSort(arr);
        //Test.binarySort(arr);
        //Test.shellSort(arr);
        //Test.mergeSort(arr, 0, 9);
//        Test.selectSort(arr, 10);
//        Test.quickSort(arr, 0, 9);
        Test.threeSign(arr,0,9);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
