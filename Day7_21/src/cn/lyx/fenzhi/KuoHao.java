package cn.lyx.fenzhi;

import java.util.ArrayList;
import java.util.List;

public class KuoHao {
    public static void main(String[] args) {
        List<Integer> integers = diffWaysToCompute("2-1-1");
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
/*
"2*3-4*5"
2 3-4*5
  3 4*5
     4  5
*/

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
