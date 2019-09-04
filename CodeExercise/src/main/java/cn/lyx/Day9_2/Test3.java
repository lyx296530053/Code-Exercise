package cn.lyx.Day9_2;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).mapToInt(Integer::parseInt).sorted().toArray();
        test(ints);
    }

    public static void test(int[] arr) {
        int temp = 0;
        int i = 0;
        int j = arr.length - 1;
        while (arr[i] < 0 && arr[j] >= 0) {
            if (arr[i] + arr[j] == 0) {
                temp++;
                i++;
                j--;
            } else if (arr[i] + arr[j] > 0) {
                j--;
            } else i++;
        }
        System.out.println(temp);
    }
    public static void test1(int[] arr){
        int temp=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(map.containsKey(arr[i])&&map.get(arr[i])==arr[j]){
                    continue;
                }
                map.put(arr[i],arr[j]);
                map.put(arr[j],arr[i]);
                if(arr[i]+arr[j]==0){
                    temp++;
                }
            }
        }
        System.out.println(temp);
    }
}
