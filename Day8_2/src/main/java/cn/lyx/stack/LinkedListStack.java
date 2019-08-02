package cn.lyx.stack;

import java.util.Iterator;

public class LinkedListStack<Item> implements MyStack<Item> {
    private class Node {
        Node next;
        Item value;
    }

    private Node root;

    @Override
    public MyStack<Item> push(Item item) {

        Node newNode = new Node();
        newNode.value = item;
        newNode.next = root;
        root = newNode;
        return this;
    }

    @Override
    public Item pop() throws Exception {

        Node temp = root;
        if (temp == null) {
            throw new Exception("stack is empty");
        }
        Item value = root.value;
        root=root.next;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node temp = root;

            @Override
            public void remove() {

            }

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public Item next() {
                Item value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }
}
