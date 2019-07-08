package cn.lyx.everday;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            int count = 1;
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    System.out.print(arr[i] + ":" + count);
                    break;
                }
                if (arr[i + 1] == arr[i]) {
                    count++;
                } else {
                    System.out.print(arr[i] + ":" + count + "<br/>");
                    count = 1;
                }
            }
        }
    }
}
