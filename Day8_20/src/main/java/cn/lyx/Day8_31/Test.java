package cn.lyx.Day8_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inArr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int num : inArr) {
            nums.add(num);
        }
        int k = sc.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        priorityQueue.addAll(nums);
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                Integer poll = priorityQueue.poll();
                System.out.println(poll);
            }
            priorityQueue.poll();
        }
    }
}
