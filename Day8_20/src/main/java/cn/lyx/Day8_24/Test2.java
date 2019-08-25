package cn.lyx.Day8_24;

import cn.lyx.Day8_23.Test1;

import java.util.Scanner;

public class Test2 {
    public static void test() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            String string = scanner.next();
            String string1 = scanner.next();
            int a = 0;
            int b = 1;
            while (a < string.length()) {
                if (string.charAt(a) == string1.charAt(a)) {
                    a++;
                    continue;
                } else {
                    if (string.charAt(a) == '.') {
                        System.out.println(true);
                        return;
                    } else if (string.charAt(a) > string1.charAt(a)) {
                        System.out.println(false);
                       return;
                    } else {
                        System.out.println(true);
                        return;
                    }
                }
            }
            if(a==string.length()&&a==string1.length()){
                System.out.println(false);
                break;
            }
            if (a == string.length() && a < string1.length()) {
                int j = a;
                for (; j < string1.length(); j++) {
                    if (string1.charAt(j) == '0'||string1.charAt(j)=='.') {
                        continue;
                    } else
                        break;
                }
                if(j==string1.length()) {
                    b = 0;
                }
            }
            if (b == 1 || b == 2) {
                System.out.println(true);
            }else System.out.println(false);
        }
    }

    public static void test3() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String string1 = scanner.nextLine();
    StringBuilder stringBuilder=new StringBuilder();
    StringBuilder stringBuilder1=new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i)!=' '){
                stringBuilder.append(string.charAt(i));
            }
        }
        for (int i = 0; i < string1.length(); i++) {
            if(string1.charAt(i)!=' '){
                stringBuilder1.append(string1.charAt(i));
            }
        }
        String trim = stringBuilder.toString();
        String trim1 = stringBuilder1.toString();
        int a = 0;
        int b = 0;
        while (true) {
            if (a+4 > trim.length()) {
                for (int i = a; i < trim.length(); i++) {
                    System.out.print(trim.charAt(i)+" ");
                }
                for (int i = b; i < trim1.length(); i++) {
                    if(i==trim1.length()-1){

                        System.out.print(trim1.charAt(i));
                    }else {

                        System.out.print(trim1.charAt(i) + " ");
                    }
                }
                break;
            }
            for (int i = a; i < a + 4; i++) {
                System.out.print(trim.charAt(i)+" ");
            }

            System.out.print(trim1.charAt(b++));
            a+=4;
        }
    }

    public static void main(String[] args) {
      test();
    }
}