package Every;

public class KBig {
    public static void main(String[] args) {
        int[] arr={2,3,4,1,6,8,7};
        int i = find(arr, 2);
        System.out.println(i);
    }

    public static int find(int[] arr, int k) {
        int i = 0;
        int j = arr.length - 1;
        int data = 0;
        while (i <j) {
            data = quick(arr, i, j);
            if (data+1 == k) {
                break;
            }
            if (data+1 > k) {
                j = data - 1;
            }
            if (data+1 < k) {
                i = data + 1;
            }
        }
        return arr[data];
    }

    private static int quick(int[] arr, int i, int j) {
        int value = arr[i];
        int x = i + 1;
        int y = j;
        while (true) {
            while (x != j && arr[x] > value) x++;
            while (y != i && arr[y] <value) y--;
            if (x>= y) {
                break;
            }
            swap(arr, x, y);
            x++;
            y--;
        }
        swap(arr, i, y);
        return y;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

