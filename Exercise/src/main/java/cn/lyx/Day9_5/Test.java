package cn.lyx.Day9_5;

import javax.security.auth.kerberos.KerberosKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int w=scanner.nextInt();
        int h=scanner.nextInt();
        int[][] arr=new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                arr[i][j]=scanner.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ArrayList<Integer> list=new ArrayList<>();

            }
        }
    }
    public static void sort(int[] arr){
        Arrays.sort(arr);
    }
}