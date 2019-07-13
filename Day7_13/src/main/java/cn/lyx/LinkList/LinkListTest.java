package cn.lyx.LinkList;

import java.util.LinkedList;

public class LinkListTest implements LinkLists {
    private class Node {
        private Node pre;
        private Object value;
        private Node next;

        public Node(Node pre, Object value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }

    }

    private Node head;
    private Node last;
    private int size;

    @Override
    public void add(Object o) {
        Node temp = last;
        Node node = new Node(temp, o, null);
        last = node;
        if (head == null) {
            head = node;
        } else {
            temp.next = node;
        }
        size++;
    }

    public void addAsfirst(Object o) {
        Node temp = head;
        Node node = new Node(null, o, temp);
        head = node;
        if (last == null) {
            last = node;
        } else {
            temp.pre = node;
        }
        size++;
    }

    @Override
    public void delete(Object o) {
        if (o == null) {
            for (Node head = this.head; head != null; head = head.next) {
                if (head.value == null) {
                    unlink(head);
                }
            }
        } else {
            for (Node head = this.head; head != null; head = head.next) {
                if (head.value.equals(o)) {
                    unlink(head);
                }
            }
        }
        size--;
    }

    private void unlink(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        if (pre == null) {
            head = next;
        } else {
            pre.next = next;
            pre = null;
        }
        if (next == null) {
            last = pre;
        } else {
            next.pre = pre;
            next = null;
        }
        node.value = null;
        size--;
    }

    @Override
    public void show() {
        for (Node head = this.head; head != null; head = head.next) {
            System.out.println(head.value);
        }
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkListTest lists = new LinkListTest();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.addAsfirst(3);
        lists.addAsfirst(2);
        lists.show();
        System.out.println("                               ");
        lists.delete(1);
        lists.show();
    }
}
