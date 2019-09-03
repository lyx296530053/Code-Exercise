package cn.lyx.Day9_1;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] arr = new int[a];

        for (int i = 0; i < a; i++) {
            arr[i] = scanner.nextInt();
        }
        int i = get(arr, b);
        System.out.println(i);
    }

    public static int get(int[] arr, int s) {
        int zz = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = i; j < arr.length; j++) {
                if ((temp += arr[j]) == s) {
                    zz = Math.max(zz, j-i);
                }
            }
        }
        return zz;
    }

}
