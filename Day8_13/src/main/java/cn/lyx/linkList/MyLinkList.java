package cn.lyx.linkList;

import javax.xml.soap.Node;
import java.rmi.MarshalledObject;
import java.util.HashMap;

public class MyLinkList {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 初级
     */
    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.value));
            temp = temp.next;
        }
        temp = head;

        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).rand = map.get(temp.rand);
            temp = temp.next;
        }
        return map.get(head);
    }

    /**
     * 进阶
     */
    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            temp.next = new Node(temp.value);
            temp.next.next = next;
            temp = next;
        }
        temp = head;
        Node copy = null;
        while (temp != null) {
            Node next = temp.next.next;
            copy = temp.next;
            copy.rand = temp.rand == null ? null : temp.rand.next;
            temp = next;
        }

        temp = head;
        while (temp != null) {
            Node next = temp.next.next;
            copy = temp.next;
            copy.next = temp.next == null ? null : temp.next.next;
            temp = next;
        }
        return head.next;
    }

    public static void printRandLinkedList(Node head) {

        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}
