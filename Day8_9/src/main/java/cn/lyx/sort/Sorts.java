package cn.lyx.sort;


public class Sorts {
    public static void ThreeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int lt = l;
        int gt = r+1;
        int temp = arr[l];
        int i = l + 1;
        while (i < gt) {
            if (arr[i] < temp) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i] > temp) {
                swap(arr, i, gt - 1);
                gt--;
            } else i++;
        }
        swap(arr, l, lt);
        ThreeSort(arr, l, lt);
        ThreeSort(arr, gt, r);
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 4, 7, 1, 9, 10, 11, 6};
        //Sort.quickedSort(arr,0,9);
        Sorts.ThreeSort(arr, 0, 9);
        for (int i : arr
                ) {
            System.out.print(i + ",");
        }
    }
}
