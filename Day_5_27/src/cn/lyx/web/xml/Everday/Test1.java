package cn.lyx.web.xml.Everday;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = a > b ? a : b;
        int temp = 1;
        for (int i = 1; i <= c; i++) {
            if (a % i == 0 && b % i == 0) {
                if (i > temp) {
                    temp = i;
                }
            }
        }
        System.out.println(a * b / temp);
    }
}
