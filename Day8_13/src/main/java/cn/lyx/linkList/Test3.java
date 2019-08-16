package cn.lyx.linkList;

import org.junit.Test;

import java.util.ArrayList;

public class Test3 {
    public static String replaceSpace(StringBuffer str) {
        int i = 0;
        int length = str.length();
        if (str.length() == 1) {
            str.replace(0, 1, "%20%20%20");
            return str.toString();
        }
        while (i < length) {
            if (str.charAt(i) == ' ') {
                str.replace(i, i + 1, "%20");
            }
            i++;
        }
        return str.toString();
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> list = new ArrayList<>();
            ListNode listNode1 = get(listNode);
            while (listNode1 != null) {
                list.add(listNode1.val);
                listNode1 = listNode1.next;
            }
            return list;
        }

        public ListNode get(ListNode listNode) {
            if (listNode == null || listNode.next == null) {
                return listNode;
            }
            ListNode next = listNode.next;
            ListNode listNode1 = get(next);
            next.next = listNode;
            listNode.next = null;
            return listNode1;
        }

        public ListNode get1(ListNode listNode) {
            if (listNode == null || listNode.next == null) {
                return listNode;
            }
            ListNode temp = null;
            while (listNode != null) {
                ListNode next = listNode.next;
                listNode.next = temp;
                temp = listNode;
                listNode = next;
            }
            return temp;
        }
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int min = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[min] > array[j]) {
                min = j;
            }
        }
        return array[min];
    }

    public int Fibonacci(int n) {
        int i = get1(n, 0, 0, 0);
        return i;
    }

    public int get1(int n, int s, int num1, int num2) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (n == s) {
            return num2;
        }
        if (s == 0) {
            num1 = 0;
        }
        if (s == 1) {
            num2 = 1;
        }
        int i = get1(n, ++s, num2, num2 + num1);
        return i;
    }

    public int JumpFloor(int target) {
        if (target ==0 ) {
            return 0;
        }else if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else if(target==3){
            return 3;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
    public int JumpFloorII(int target) {
        if (target ==0 ) {
            return 0;
        }else if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else if(target==3){
            return 3;
        }
        return JumpFloorII(target-1)+JumpFloorII(target-2)+target-2;
    }
    public static void main(String[] args) {

        int i = new Test3().JumpFloorII(3);
        System.out.println(i);
    }
}
