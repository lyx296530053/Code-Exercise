package cn.lyx.Day9_4;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    static ListNode partition(ListNode head, int m) {

        ListNode start = null;
        ListNode node = null;
        ListNode ss = head;
        ListNode start1 = null;
        ListNode node1 = null;
        while (ss != null) {
            if (ss.val <= m) {
                if (start == null) {
                    node = new ListNode(ss.val);
                    start = node;
                } else {
                    node.next = new ListNode(ss.val);
                    node = node.next;
                }
            } else {
                if (ss.val > m) {
                    if (start1 == null) {
                        node1 = new ListNode(ss.val);
                        start1 = node1;
                    } else {
                        node1.next = new ListNode(ss.val);
                        node1 = node1.next;
                    }
                }
            }
            ss = ss.next;
        }
        node.next = start1;
        return start;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        int n = in.nextInt();
        for (int i = 0; i < m; i++) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, n);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(" ");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
