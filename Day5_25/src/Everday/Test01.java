package Everday;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        int i=scanner.nextInt();
        int j=scanner.nextInt();
        int a,b,c;
        b=(i-x)/2;
        a=b+x;
        c=b-y;
        if(b+a==i&&b+c==j){
            System.out.println(a+" "+b+" "+c);
        }else {
            System.out.println("No");
        }
    }
}
