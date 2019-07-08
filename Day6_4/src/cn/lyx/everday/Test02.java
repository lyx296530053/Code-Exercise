package cn.lyx.everday;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b=a;
        int c=0;
        a = a * (a - 1) + 1;
        for (int i = a; i<a+2*b ; i+=2) {
            if (i == a + 2 * (b - 1)) {
                System.out.println(i);
                c++;
            } else {
                System.out.print((i) + "+");
                c++;
            }
        }
        System.out.println(c);
    }
}
