package Sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 3, 7, 8, 3, 6, 9};
        bubbleSort(arr);
        insertSort(arr);
        binarySort(arr);
        shellSort(arr);
        mergeSort(arr, 0, 9);
        selectSort(arr,10);
        quickSort(arr, 0, 9);
        threeSign(arr,0,9);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
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

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
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

    public static void binarySort(int[] arr) {
        int mid, low, high;
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            low = 0;
            high = i - 1;
            int j = i - 1;
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
        if (j <= high) {
            start = j;
            end = high;
        }
        while (start <= end) {
            temp[k++] = arr[start++];
        }
        for (int l = 0; l <= high - low; l++) {
            arr[l + low] = temp[l];
        }
    }

    public static void selectSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
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

    private static int doubleSign(int[] arr, int low, int high) {
        int value = arr[low];
        int i = low + 1;
        int j = high;
        while (i < high) {
            while (i <= high && arr[i] < value) i++;
            while (j >= low && arr[j] > value) j--;
            if (i >j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
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

    public static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;

    }
    public static void threeSign(int[] arr,int low, int high){
        if(low>=high) return ;
        int value=arr[low];
        int i=low+1;
        int lt=low;
        int gt=high;
        while(i<gt){
            if(arr[i]>value){
                swap(arr,i,gt-1);
                gt--;
            }else if(arr[i]<value){
                swap(arr,i,lt+1);
                i++;
                lt++;
            }else
                i++;
        }
        swap(arr,low,lt);
        threeSign(arr,low,lt);
        threeSign(arr,gt,high);
    }
}
