package cn.lyx.Day9_4;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {


    static void resolve(String expr) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                a++;
            } else if (expr.charAt(i) == ')') {
                b++;
            }
        }
        if (a != b) {
            System.out.println("");
            return;
        }

        Stack<Character> stack = new Stack();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) != ')') {
                stack.push(expr.charAt(i));
            } else {
                if (i == expr.length() - 1) {
                    break;
                }
                Queue queue = new LinkedList();
                while (stack.peek() != '(') {
                    queue.add(stack.pop());
                }
                stack.pop();
                while (!queue.isEmpty()) {
                    stack.push((Character) queue.poll());
                }
            }
        }
        while (stack.peek() != '(') {
            System.out.print(stack.pop());
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        resolve(_expr);

    }
}

