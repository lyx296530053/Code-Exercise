package cn.lyx.Day9_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] ints1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int temp=0;
        int s=0;
        for (int i = 0; i < ints.length; i++) {
            int j=s;
            for (; j < ints1.length-1; j++) {
                if(ints1[j]<ints[i]){
                    s=j;
                    continue;
                }else {
                    s=j;
                    temp++;
                    break;
                }
            }
            if(s==ints1.length){
                break;
            }
        }
        System.out.println(temp);
    }
}
