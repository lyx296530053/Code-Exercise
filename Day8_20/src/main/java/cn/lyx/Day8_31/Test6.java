package cn.lyx.Day8_31;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int[] chars=new int[a];
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < a; i++) {
            chars[i]= i+1;
        }
        List<String> test = test(chars, 0, "", list);
        for (String s : test) {
            int aa=0;
            for (int i = 0; i < s.length(); i++) {
                Integer integer = Integer.valueOf(s.charAt(i))-48;
                aa+=integer;
            }
            if(aa==b){
                for (int i = 0; i < s.length(); i++) {
                    if(i==s.length()-1){
                        System.out.print(s.charAt(i));
                    }else
                    System.out.print(s.charAt(i)+" ");
                }
                System.out.println();
            }
        }
    }
    public static List<String> test(int[] arr, int i, String str, List<String> list){
        if(i==arr.length){
             list.add(str);
             return list;
        }
        test(arr,i+1,str+arr[i],list);
        test(arr,i+1,str,list);
        return list;
    }
}
