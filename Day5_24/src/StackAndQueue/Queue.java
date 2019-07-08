package StackAndQueue;

import java.util.Iterator;

class LinkedList<T> implements QueueTest<T> {
    private class Node {
        Node next;
        T data;

        public Node(T t, Node o) {
            this.data = t;
            this.next = o;
        }
    }

    private Node head ;
    private Node last ;
    private int size;

    @Override
    public QueueTest<T> add(T t) {
        Node newNode = new Node(t, null);
        if (isEmpty()) {
            head = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;

        }
        size++;
        return this;
    }

    @Override
    public T remove() throws Exception {
        T t = head.data;
        head = head.next;
        size--;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
    }
}

public class Queue {
    public static void main(String[] args) {
        QueueTest<Integer> queueTest = new LinkedList<>();
        queueTest.add(1);
        queueTest.add(2);
        queueTest.add(3);
        queueTest.add(4);
        System.out.println(queueTest.size());
        Iterator<Integer> iterator = queueTest.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
