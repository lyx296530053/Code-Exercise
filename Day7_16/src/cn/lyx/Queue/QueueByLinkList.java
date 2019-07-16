package cn.lyx.Queue;

import java.util.Iterator;

public class QueueByLinkList<T> implements MyQueue<T> {
    private class Node {
        T t;
        Node next;

    }

    Node first;
    Node last;
    int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public MyQueue<T> add(T t) {
        Node node = new Node();
        node.t = t;
        node.next = null;
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
        return this;
    }

    @Override
    public T remove() throws Exception {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        Node temp = first;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return temp.t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = first;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T t = temp.t;
                temp = temp.next;
                return t;
            }
        };
    }
}
