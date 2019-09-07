package cn.lyx.Day9_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        for (int i = 0; i < a; i++) {
            ArrayList<Integer> arrayList =new ArrayList<>();
            int b=scanner.nextInt();
            while (b!=0){
                int i1 = b % 2;
                arrayList.add(i1);
                b/=2;
            }
            is(arrayList);
        }
    }
    public static void is(ArrayList list){
        Object[] objects = list.toArray();
        int a=0;
        int b=objects.length-1;
        while (a<b){
            if(objects[a]!=objects[b]){
                System.out.println("No");
                return;
            }
            a++;
            b--;
        }
        System.out.println("Yes");
    }
}
