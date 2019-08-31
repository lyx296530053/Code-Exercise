package cn.lyx.Day8_31;

import java.util.Arrays;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        String s=scanner.nextLine();
//        char[] chars = s.toCharArray();
//        String s1 = "";
//        String temp="";
//        for (int i = 0; i < chars.length; i++) {
//            if(chars[i]>='1'&&chars[i]<='9'){
//                s1+=chars[i];
//            }else {
//                if(s1.length()>temp.length()){
//                    temp=s1;
//                }
//                s1="";
//            }
//        }
//        System.out.println(temp);
        test3();
    }
    public static void test3(){
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        Integer integer = Integer.valueOf(split[split.length-1]);
        String[] arr=new String[split.length-1];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=split[i];
        }
        int[] ints = Arrays.stream(arr).mapToInt(Integer::parseInt).sorted().toArray();
        for (int i = 0; i < integer; i++) {
            if(i==integer-1){
                System.out.print(ints[i]);
            }else
            System.out.print(ints[i]+" ");

        }
    }
}
