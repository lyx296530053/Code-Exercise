package cn.lyx.Day8_30;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                result += arr[i];
            } else result = arr[i];
            if(result<arr[i]){
                result=arr[i];
            }
        }
        System.out.println(result);
    }
}
