package cn.lyx.Day9_8;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] arr = new char[26];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = 65;
            } else {
                int t = i - 1;
                char c = arr[i - 1];
                c += 1;
                arr[i] = c;
            }
        }
        PriorityQueue<String> str = new PriorityQueue<>((o1, o2) -> {
            int i = 0;
            while (true) {
                if (i == o1.length() || i == o2.length()) {
                    return 0;
                }
                if (o1.charAt(i) < o2.charAt(i)) {
                    return 1;
                } else if (o1.charAt(i) == o2.charAt(i)) {
                    i++;
                } else return -1;
            }
        });
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) > '2') {
                str.add(String.valueOf(arr[s.charAt(i) - 49]));
            } else {
                if (s.charAt(i) == '1') {
                    str.add(String.valueOf(arr[s.charAt(i) - 49] + "" + arr[s.charAt(i + 1) - 49]));
                    int i1 = (s.charAt(i) - 48)* 10;
                    str.add(String.valueOf(arr[(i1)+ s.charAt(i + 1) - 48+ 1]));
                } else {
                    str.add(String.valueOf(arr[s.charAt(i) - 48]));
                    if (s.charAt(i + 1) <= '6') {
                        str.add(String.valueOf(arr[(s.charAt(i) - 48) * 10 + s.charAt(i + 1) - 48 + 1]));
                    } else
                        str.add(String.valueOf(arr[s.charAt(i + 1) - 48]));
                    continue;
                }
                i++;
            }
        }
        Stack stack = new Stack();
        while (!str.isEmpty()) {
            stack.add(str.poll());

        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
