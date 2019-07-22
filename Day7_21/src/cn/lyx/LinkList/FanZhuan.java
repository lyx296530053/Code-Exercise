package cn.lyx.LinkList;

import java.util.LinkedList;
import java.util.List;

public class FanZhuan {
    class Node {
        Node next;
        int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    Node head = new Node(null, -1);

    public void add(int node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node node1 = new Node(null, node);
        temp.next = node1;
    }

    public void show() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.value);
        }
    }

    public Node reserve(Node head) {
        Node temp = null;
        Node newNode = null;
        while (head != null) {
            temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        }
        head.next = newNode.next;
        return head;
    }

    public Node reserve1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        Node node = reserve1(next);
        next.next = head;
        head.next = null;
        return null;
    }

    public Node merge(Node a) {
        if(a==null){
            return head;
        }
        if(head==null){
            return a;
        }
        if(head.next.value<a.next.value){
           // head.next.next=merge(head.next.next,a.next);
        }
        return  null;
    }

    public static void main(String[] args) {
        FanZhuan fanZhuan = new FanZhuan();
        fanZhuan.add(1);
        fanZhuan.add(2);
        fanZhuan.add(3);
        FanZhuan fanZhuan1 = new FanZhuan();
        fanZhuan1.add(1);
        fanZhuan1.add(2);
        fanZhuan1.add(3);
        Node merge = fanZhuan.merge(fanZhuan1.head);
        while(merge.next!=null){
            System.out.println(merge.next.value);
        }
    }
}
