package cn.lyx.everday;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        String[] sb=getGray(a);
        System.out.print("[");
        for (int i = 0; i < sb.length; i++) {

            System.out.print(sb[i]);

            if(i<sb.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
   public static String[] getGray(int n){
        int length= (int) Math.pow(2,n);
        StringBuilder[] a=new StringBuilder[length];
        if(n==1){
            a[0]=new StringBuilder("0");
            a[1]=new StringBuilder("1");
        }else {
            String[] b=getGray(n-1);
            for (int i = 0; i < length; i++) {
                if(i<length/2){
                    a[i]=new StringBuilder(b[i]);
                    a[i].insert(0,"0");
                }else {
                    a[i]=new StringBuilder(b[length-i-1]);
                    a[i].insert(1,"1");
                }
            }
        }
           String[] q=new String[a.length];
           for (int i = 0; i < a.length; i++) {
               q[i]= String.valueOf(a[i].append("\""));
           }
           return q;
       }
    }
