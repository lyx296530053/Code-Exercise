class Sort {
    public static void quickedSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = doubleSign(arr, low, high);
        quickedSort(arr, low, q - 1);
        quickedSort(arr, q + 1, high);
    }

    public static int doubleSign(int[] arr, int low, int high) {
        int value = arr[low];
        int i = low + 1;
        int j = high;
        while (i < high) {
            while (i <= high && arr[i] < value) i++;
            while (j >= low && arr[j] > value) j--;
            if (i > j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    public static void threeSign(int[] arr, int low, int high) {
        if (low >= high) return;
        int value = arr[low];
        int i = low + 1;
        int gt = high;
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
        int[] arr = new int[]{2, 5, 3, 4, 7, 1, 9, 10, 11, 6};
        //Sort.quickedSort(arr,0,9);
        Sort.threeSign(arr, 0, 9);
        for (int i : arr
                ) {
            System.out.print(i + ",");
        }

    }
}
