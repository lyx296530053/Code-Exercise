package cn.lyx.Day9_2;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int temp = 1;
        while (a /2!= 0) {
            int temp1=0;
            temp1 = a % 2;
            if(temp1==1) {
                temp++;
            }
            a/=2;
        }
        System.out.println(temp);
    }
}
