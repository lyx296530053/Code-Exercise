package cn.lyx.Day8_31;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int[] arr=new int[b];
        for (int i = 0; i< b; i++) {
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);
        int temp=0;
        for (int i = 0; i<=arr.length-1; i++) {
            int n=temp;
         temp+=arr[i];
         if(temp>a){
             System.out.println(n+1);
             break;
         }
        }

    }
}
