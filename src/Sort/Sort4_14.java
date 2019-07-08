package Sort;

/**
 * Created by lyx on 2019/4/14.
 */
public class Sort4_14 {
        public static void insertSort(int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; i++) {
                int value = arr[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (arr[j] > value) {
                        arr[j + 1] = arr[j];
                    } else
                        break;
                }
                arr[j + 1] = value;
            }
        }

        public static void binarySort(int[] arr) {
            int n = arr.length;
            int low, high, mid, j;
            for (int i = 1; i < n; i++) {
                int value = arr[i];
                j = i - 1;
                low = 0;
                high = i - 1;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (arr[mid] > value) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                for (; j > high; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = value;
            }
        }

        public static void shellSort(int[] arr) {
            int setp = arr.length / 2;
            while (setp >= 1) {
                for (int i = setp; i < arr.length; i++) {
                    int j = i - setp;
                    int value = arr[i];
                    for (; j >= 0; j -= setp) {
                        if (arr[j] > value) {
                            arr[j + setp] = arr[j];
                        } else
                            break;
                    }
                    arr[j + setp] = value;
                }
                setp = setp / 2;
            }
        }

        public static void mergeSort(int[] arr, int low, int high) {
            if (low >= high) {
                return;
            }
            int mid = (high + low) / 2;
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
                arr[low + i] = temp[i];
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
            for (int i = low + 1; i <= high; i++) {
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
            int j = high;
            int i = low + 1;
            while (true) {
                while (i <= high && arr[i] < value) i++;
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

        public static void threeSign(int[] arr, int low, int high) {
            if (low >= high) {
                return;
            }
            int i = low + 1;
            int lt = low;
            int value = arr[low];
            int gt = high + 1;
            while (i < gt) {
                if (arr[i] > value) {
                    swap(arr, i, gt - 1);
                    gt--;
                } else if (arr[i] < value) {
                    swap(arr, i, lt + 1);
                    lt++;
                    i++;
                } else {
                    i++;
                }
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

