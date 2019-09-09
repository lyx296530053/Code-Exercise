package cn.lyx.Day9_8;

import java.util.Arrays;
import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l=scanner.nextInt();
        int r=scanner.nextInt();
        if(l==ints[0]||r==ints[0]){
            System.out.println(ints[0]);
        }
        if(l<ints[0]&&r<ints[0]){
            
        }
    }
}
