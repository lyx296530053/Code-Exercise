package cn.lyx.Day8_27;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Test2 {
    public static void test1() {
        String s = "3+2+1+-4*-5+1";
        Stack stack = new Stack();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '/' || s.charAt(i) == '+' || s.charAt(i) == '*') {
                stack.push(s.charAt(i));
                i++;
                continue;
            }
            if (s.charAt(i) == '-' && (stack.peek().equals('+') || stack.peek().equals('-') || stack.peek().equals('*') || stack.peek().equals('/'))) {
                String s1 = null;
                while (i < s.length() && (s.charAt(i) != '-' || s.charAt(i) != '+')) {
                    s1 += s.charAt(i);
                    i++;
                }
                Integer integer = Integer.valueOf(s1);
                if (!stack.isEmpty() && stack.peek().equals('-')) {
                    stack.push(s1);
                } else if (!stack.isEmpty()) {
                    char pop = (char) stack.pop();
                    String pop1 = (String) stack.pop();
                    Integer integer1 = Integer.valueOf(pop1);
                    if (integer - integer1 > 0) {
                        stack.push(integer1);
                        stack.push(pop);
                        stack.push(integer);
                    } else {
                        stack.push(integer);
                        stack.push(pop);
                        stack.push(integer1);
                    }
                }
                continue;
            }
            String s1 = "";
            while (i < s.length() && (s.charAt(i) != '-' && s.charAt(i) != '+')) {
                s1 += s.charAt(i);
                i++;
            }
            Integer integer = Integer.valueOf(s1);
            if (!stack.isEmpty() && stack.peek().equals('-')) {
                stack.push(s1);
            } else if (!stack.isEmpty()) {
                char pop = (char) stack.pop();
                String pop1 = (String) stack.pop();
                Integer integer1 = Integer.valueOf(pop1);
                if (integer - integer1 > 0) {
                    stack.push(integer1);
                    stack.push(pop);
                    stack.push(integer);
                } else {
                    stack.push(integer);
                    stack.push(pop);
                    stack.push(integer1);
                }
            } else stack.push(s1);
        }
        System.out.println(1);
    }

    public static int test4(int num) {
        if (num == 1) {
            return 1;
        }
        int add = 1;
        int i = 1;
        int k = 1;
        while (true) {
            for (int j = 0; j < i; j++) {
                add += 1;
                k++;
                if (k == num) {
                    return add;
                }
            }
            i++;
            add -= 1;
            k++;
            if (k == num) {
                return add;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            int i = test4(a);
            System.out.println(i);
        }
    }
}
