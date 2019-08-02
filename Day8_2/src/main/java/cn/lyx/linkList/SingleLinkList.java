package cn.lyx.linkList;

import javafx.beans.binding.When;
import org.junit.Test;

import java.util.LinkedList;

public class SingleLinkList<T> implements Lists<T> {
    class Node {
        Node next;
        T value;
    }

    private Node root = new Node();
    private int size;

    @Override
    public void addAsFirst(T t) {
        Node node = new Node();
        node.value = t;
        node.next = root.next;
        root = node;
        size++;
    }

    @Override
    public void addAsLast(T t) {
        Node temp = root;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
        }
        Node node = new Node();
        node.value = t;
        temp.next = node;
        node.next = null;
        size++;
    }

    @Override
    public void remove(T t) {

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
        Node temp = root;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            System.out.println(temp.value);
        }
    }

    public void reverse() {
        Node temp = root.next;
        Node next = null;
        Node newNode = null;
        while (temp != null) {
            next = temp.next;
            temp.next = newNode;
            newNode = temp;
            temp = next;
        }
        root.next = newNode;
    }
}
