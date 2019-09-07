package cn.lyx.Day9_5;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt();
        int M = m;
        int S = scanner.nextInt();
        int T = scanner.nextInt();
        int size = 10;
        while (T >= 0) {

            while (size < 10) {
                size += 4;
                T--;
            }
            if(size>=10){
                M += 50;
                size -= 10;
            }
            if(M>=S){
                break;
            }
        }
        if(T<0){
            System.out.println("No");
        }else {
            System.out.println("Yes"+(M-m));
        }
    }
}
