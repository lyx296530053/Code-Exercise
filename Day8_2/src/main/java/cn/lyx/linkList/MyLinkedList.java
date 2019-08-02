package cn.lyx.linkList;

import com.sun.glass.ui.Size;

import java.util.LinkedList;

public class MyLinkedList<T> implements Lists<T> {
    private class Node {
        Node pre;
        T value;
        Node aft;

        public Node(Node o, T t, Node root) {
            this.pre = o;
            this.value = t;
            this.aft = root;
        }
    }

    private Node first;
    private Node last;
    private int size;

    @Override
    public void addAsFirst(T t) {
        Node temp = first;
        Node newNode = new Node(null, t, first);
        first = newNode;
        if (temp == null) {
            last = newNode;
        } else {
            temp.pre = newNode;
        }
        size++;
    }

    @Override
    public void addAsLast(T t) {
        Node temp = last;
        Node newNode = new Node(first, t, null);
        last = newNode;
        if (temp == null) {
            first = newNode;
        } else {
            temp.aft = newNode;
        }
        size++;
    }

    @Override
    public void remove(T t) {
        if (t == null) {
            for (Node temp = first; temp != null; temp = temp.aft) {
                if (temp.value.equals(t)) {
                    unlike(temp);
                }
            }
        }
    }

    public void unlike(Node node) {
        Node aft = node.aft;
        Node pre = node.pre;
        if (aft == null) {
            last = pre;
        } else {
            aft.pre = pre;
            node.aft = null;
        }
        if (pre == null) {
            first = aft;
        } else {
            pre.aft = aft;
            node.pre = null;
        }
        size--;
    }

    @Override
    public void update(T t) {

    }

    @Override
    public T find() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void show() {
        Node temp = first;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.value);
            temp = temp.aft;
        }
    }
}
