package cn.lyx.Day8_30;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        if(b.length()==0||a.length()==0){
            return;
        }
        int[][] arr = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (i - 1 >= 0 && j - 1 >= 0 && arr[i - 1][j - 1] !=0) {
                    if (a.charAt(i) == b.charAt(j)) {
                        arr[i][j] =  arr[i - 1][j - 1] +1;
                    }
                } else {
                    if (a.charAt(i) == b.charAt(j)) {
                        arr[i][j] = 1;
                    }
                }
            }
        }
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                temp = Math.max(temp, arr[i][j]);
            }
        }
        int aa = 0,bb = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if(arr[i][j]==temp){
                    aa=i;
                    bb=j;
                }
            }
        }
        String s="";
        aa-=temp-1;
        bb-=temp-1;
        for (int i = 0; i < temp; i++) {
            s+=a.charAt(aa++);
        }
        System.out.println(s);
    }
}
