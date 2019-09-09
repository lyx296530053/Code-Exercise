package cn.lyx.Day9_8;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr=new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i]=scanner.nextInt();
        }
        int size=scanner.nextInt();
        for (int i = 0; i <3 ; i++) {
            if(arr[i]==size){
                System.out.println(1);
                return;
            }
        }

    }
}
