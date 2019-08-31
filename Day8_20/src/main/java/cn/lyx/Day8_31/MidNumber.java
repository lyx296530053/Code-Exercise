package cn.lyx.Day8_31;

import java.text.DecimalFormat;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MidNumber {
    static PriorityQueue<Double> max = new PriorityQueue<Double>((o1, o2) -> (int) (o2 - o1));
    static PriorityQueue<Double> min = new PriorityQueue<>(Double::compareTo);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    push(scanner.nextInt());
                    break;
                case 2:
                    get();
                    break;
            }
        }
    }

    public static void push(double num) {
        if (max.isEmpty()) {
            max.add(num);
        } else if (max.size() > min.size() && num < max.peek()) {
            min.add(max.poll());
            max.add(num);
        } else if (max.size() < min.size() && num > max.peek()) {
            max.add(min.poll());
            min.add(num);
        } else if (num < max.peek()) {
            max.add(num);
        } else min.add(num);
    }

    public static void get() {
        if(max.isEmpty()||min.isEmpty()){
            System.out.println(-1);
            return;
        }
        DecimalFormat df=new DecimalFormat("#.0");
        if (min.size() == max.size()) {
            System.out.println(df.format((min.peek() + max.peek()) / 2.0));
        } else if (max.size() > min.size()) {
            System.out.println(max.peek()+".0");
        }else System.out.println(min.peek()+".0");
    }
}
