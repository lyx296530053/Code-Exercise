package cn.lyx.Day8_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String str=scanner.next();
        List<String> list=new ArrayList<>();
        List<String> test = test(str.toCharArray(), 0,str.length(), list);
        String[] strings = test.toArray(new String[test.size()]);
        Arrays.sort(strings);
        System.out.print("[");
        for (int i = 0; i < strings.length; i++) {
            if(i==strings.length-1) {
                System.out.print(strings[i]);
            }else
            System.out.print(strings[i]+",");
        }

        System.out.println("]");

    }
    public static List<String> test(char[] arr, int strat,int end, List<String> list){
        if(strat==end){
            if(!list.contains(String.valueOf(arr))){
                list.add(String.valueOf(arr));
            }
        }
        for (int i =strat ; i < arr.length; i++) {
            swap(arr,i,strat);
            test(arr,strat+1,arr.length,list);
            swap(arr,i,strat);
        }
        return list;
    }

    public static void swap(char[] arr,int a,int b){
        char temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
