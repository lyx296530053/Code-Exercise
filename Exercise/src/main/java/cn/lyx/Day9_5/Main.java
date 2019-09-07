package cn.lyx.Day9_5;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    static int solution(int[] prices, int budget) {
        int length = prices.length - 1;
        Arrays.sort(prices);
        if (budget < prices[length]) {
            length-=1;
            while (budget<prices[length]||length>=0){
                length--;
            }
            if(length<0){
                return -1;
            }
            int i = budget / prices[length];
            int i1 = budget - i * (prices[length]);
            length -= 1;
            while (length >= 0) {
                if (i1 == prices[length]) {
                    i += 1;
                    i1 = 0;
                } else if (i1 > prices[length]) {
                    int j = i1 / prices[length];
                    i += j;
                    i1 = i1 - j * (prices[length]);
                } else {
                    length -= 1;
                }
                length--;
            }
            return i;
        } else if (budget == prices[length]) {
            return 1;
        } else {
            int i = budget / prices[length];
            int i1 = budget - i * (prices[length]);
            length -= 1;
            while (length >= 0) {
                if (i1 == prices[length]) {
                    i += 1;
                    i1 = 0;
                } else if (i1 > prices[length]) {
                    int j = i1 / prices[length];
                    i += j;
                    i1 = i1 - j * (prices[length]);
                } else {
                    length -= 1;
                }
                length--;
            }
            return i;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for (int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
