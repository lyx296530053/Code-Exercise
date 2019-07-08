package cn.lyx.everday;


import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            if (arr[i] != 0) {
                System.out.print(i);
                arr[i]--;
                break;
            }
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                System.out.print(i);
            }
        }
    }
}
