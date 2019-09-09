package cn.lyx.Day9_8;


import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt();
        int[] arr=new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]=scanner.nextInt();
        }
        int num=0;
        int xia=0;
        for (int i = 0; i < size; i++) {
            int num1=0;
            int j=i+1;
            while (j<=size-1){
                boolean flag=true;
                for (int k = i+1; k <=j-1 ; k++) {
                    if(arr[j]>arr[i]||arr[j]<arr[k]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    num1++;
                }
                j++;
            }
            if(num1>num){
                num=num1;
                xia=i;
            }
        }
        System.out.println(arr[xia]);
    }
}
