package cn.lyx.Day9_4;

import java.util.Scanner;

public class JumpGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = scanner.nextInt();
        }
        int i = arr.length - 1;
        int n=0;
        while (i >= 0) {
            int temp = i;
            int j = Integer.MIN_VALUE;
            boolean flag=false;
            while (temp > 0) {
                if (arr[temp - 1] + (temp - 1) >= i) {
                    flag=true;
                    Math.max(j, temp);
                    j = temp-1;
                }
                temp--;
            }
            if(!flag){
                return;
            }
            n++;
            if(j==0){
                System.out.println(n);
                break;
            }
            i=j;
        }
    }
}
