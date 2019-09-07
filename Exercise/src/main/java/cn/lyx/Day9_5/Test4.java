package cn.lyx.Day9_5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            int range = scanner.nextInt();
            int day = scanner.nextInt();
            int[] arr = new int[day];
            for (int j = 0; j < day; j++) {
                arr[j] = scanner.nextInt();
            }
            if(range==0){
                System.out.println(30);
                continue;
            }
            if(day==0){
                System.out.println(30/(range+1));
                continue;
            }
            int temp = 0;
            int i1 = 1;
            int a = 0;
            while (true) {
                if ((i1 + range +1)< arr[a]) {
                    if(temp==0){
                        temp+=1;
                    }
                    temp++;
                    i1 += (range+1);
                } else if (i1 + range+1 > arr[a]) {
                    i1 = arr[a];
                    a++;
                    if(temp==0){
                        temp++;
                    }
                } else if ((i1 + range+1) == arr[a]) {
                    i1 = arr[a];
                    a++;
                    temp++;
                }
                if(a==arr.length){
                   while (i1+range+1<=30){
                       temp++;
                       i1 += (range+1);
                   }
                }
                if(i1+range+1>=30){
                    if(i1+range+1==30){
                        System.out.println(temp+1);
                        break;
                    }
                    System.out.println(temp);
                    break;
                }
            }
        }
    }
}
