package StackAndQueue;

import java.util.Iterator;

class LinkList<T> implements StackTest<T> {
    private class Node {
        Node next;
        T data;
        public Node() {
        }
    }
    private Node head = null;
    private int size = 0;

    @Override
    public StackTest<T> push(T t) {
        Node newNode = new Node();
        newNode.data = t;
        newNode.next = head;
        head = newNode;
        size++;
        return this;
    }

    @Override
    public T pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack is null");
        }
        T temp=head.data;
        head=head.next;
       return temp;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return  new Iterator() {
           private Node next=head;
            @Override
            public boolean hasNext() {
                return next!=null;
            }

            @Override
            public T next() {
                T data = next.data;
                next=next.next;
                return data;
            }
        };
    }
}

public class StackByLinkList {
    public static void main(String[] args) throws Exception {
        StackTest stackTest=new LinkList();
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(3);
        stackTest.push(4);
        System.out.println(stackTest.size());
        Iterator<Integer> iterator = stackTest.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
        stackTest.pop();
        stackTest.pop();
        Iterator<Integer> iterator1 = stackTest.iterator();
        while(iterator1.hasNext()){
            System.out.print(iterator1.next());
        }
    }
}
