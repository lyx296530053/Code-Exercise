package cn.lyx.Day9_1;

import java.util.*;

public class Test {
    public static int getLongestPalindrome(String A, int n) {
        StringBuilder stringBuilder = new StringBuilder("#");
        for (int i = 0; i <n; i++) {
            stringBuilder.append(A.charAt(i) + "#");
        }
        A = stringBuilder.toString();
        int[] arr=new int[A.length()];
        arr[0]=1;
        for (int i = 1; i < arr.length; i++) {
            int t=i-1;
            int s=i+1;
            int temp=1;
            while (t>=0&&s<arr.length&&(A.charAt(t)==A.charAt(s))){
                temp++;
                t-=1;
                s+=1;
            }
           arr[i]=temp;
        }
        Arrays.sort(arr);
        return arr[arr.length-1]-arr[0];
    }

    public static void main(String[] args) {
        int abc1234321ab = getLongestPalindrome("baabccc", 7);
        System.out.println(abc1234321ab);
    }
}
