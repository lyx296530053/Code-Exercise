package cn.lyx.Day9_4;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        boolean f=true;
        ArrayList<Integer> list=new ArrayList<>();
        int data=scanner.nextInt();
        for (int i = 0; i < a; i++) {
            int b=scanner.nextInt();
            int c=scanner.nextInt();
            int d=scanner.nextInt();
            if(data>=c&&data<=d){
                f=false;
                list.add(b);
            }
        }
        if(f){
            System.out.println("null");
        }
        Object[] objects = Arrays.stream(list.toArray()).sorted().toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
