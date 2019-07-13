package cn.lyx.LinkList;


import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class SignList implements LinkLists {
    private class Node {
        Node next;
        Object value;

        public Node() {
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node(Node next, Object value) {
            this.next = next;
            this.value = value;
        }
    }

    private Node head = new Node();
    private int size;

    @Override
    public void add(Object o) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
        }
        Node node = new Node();
        node.setValue(o);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    @Override
    public void delete(Object o) {
        for (int i = 0; i < size; i++) {
            head = head.next;
            if (head.value.equals(o)) {
                head.next = head.next.next;
                break;
            }
        }
    }

    @Override
    public void show() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            System.out.println(temp.value);
        }

    }

    @Override
    public int size() {
        return size;
    }

    public void reverse() {
        Node reverseHead = new Node();
        while (head.next != null) {
            Node temp = head.next.next;
            head.next.next = reverseHead;
            reverseHead = head.next;
            head.next = temp;
        }
        head.next = reverseHead;
    }

    public void reverseShow() {
        Node temp = head;
        Deque deque = new LinkedList();
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            deque.push(temp.value);
        }
        Iterator iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        LinkLists lists = new SignList();
        lists.add(1);
        lists.add(3);
        lists.add(4);
        // ((SignList) lists).reverse();
        //lists.show();
        ((SignList) lists).reverseShow();
    }

}
