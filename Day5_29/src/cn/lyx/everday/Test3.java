package cn.lyx.everday;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        String str = "abcdefg";
        Scanner scanner=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        while (true) {
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            if(b==0){
                continue;
            }
            String s1 = str.substring(a, a+b);
            String s2 = str.substring(a+b);
            String s3 = str.substring(0, a);
            sb.append(s3).append(s1);
            for (int i = s1.length()-1; i >=0; i--) {
                sb.append(s1.charAt(i));
            }
            sb.append(s2);
           str=sb.toString();
           sb.delete(0,str.length());
            System.out.println(str);
        }
    }
}
