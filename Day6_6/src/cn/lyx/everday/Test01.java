package cn.lyx.everday;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr=new int[1000];
        int t=0;
        while (true) {
            Integer a=Integer.valueOf(scanner.nextLine());
            if(a==0){
                break;
            }
            String b= scanner.nextLine();
            String c=scanner.nextLine();
            String[] split = b.split(" ");
            for (int i = 0; i <split.length; i++) {
                if(c.equals(split[i])){
                    arr[t]++;
                }
            }
            t++;
        }
        for (int i = 0; i < t; i++) {
            System.out.println(arr[i]);
        }
    }
}
