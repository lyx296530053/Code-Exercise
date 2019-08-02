package cn.lyx.queue;

import java.util.Iterator;

public class ArrayQueue<Item> implements MyQueue<Item> {
    private class Node{
        Item value;
        Node next;
    }
    private  Node first;
    private  Node last;
    private int size;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public MyQueue<Item> add(Item item) {
        Node temp=last;
        Node newNode=new Node();
        newNode.next=null;
        newNode.value=item;
        last=newNode;
        if(temp==null){
            first=newNode;
        }else {
            temp.next=newNode;
        }
        size++;
        return this;
    }

    @Override
    public Item remove() throws Exception {
        return null;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public void remove() {

            }

            @Override
            public boolean hasNext() {
                return first!=null;
            }

            @Override
            public Object next() {
                Item value = first.value;
                first=first.next;
                return value;
            }
        };
    }
}
