package cn.lyx.queue;

import java.awt.*;

public class MyLinkList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        Node node = reverseList(next);
        next.next = head;
        head.next = null;
        return node;
    }

    public static boolean hasHuiWen(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node start = head;
        Node end = head.next;
        while (end != null && end.next != null) {
            start = start.next;
            end = end.next.next;
        }
        if (end != null) {
            start = start.next;
        }
        cut(head, start);
        boolean flag = isEqual(head, reserve(start));
        return flag;
    }

    private static boolean isEqual(Node head, Node reserve) {
        while (head != null && reserve != null) {
            if (head.value != reserve.value) {
                return false;
            }
            head=head.next;
            reserve=reserve.next;
        }
        return true;
    }

    private static Node reserve(Node start) {
        Node newNode = null;
        while (start != null) {
            Node Temp = start.next;
            start.next = newNode;
            newNode = start;
            start = Temp;
        }
        return newNode;
    }

    private static void cut(Node head, Node start) {
        if (head != start) {
            head = head.next;
        }
        head.next = null;
    }

    /**
     * 非递归
     */
    public static Node reverseList1(Node head) {
        Node newNode = null;
        while (head != null) {
            Node temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        }
        return newNode;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        for (Node i = head; i != null; i = i.next) {
            System.out.println(i.value);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(4);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = null;
        printLinkedList(head1);
        boolean b = hasHuiWen(head1);
        System.out.println(b);
    }
}
