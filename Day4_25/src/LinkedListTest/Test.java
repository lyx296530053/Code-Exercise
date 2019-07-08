package LinkedListTest;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Ilist list=new MyLinkedList();
        LinkedList list1=new LinkedList();
        list1.add(123);
        list1.add(345);
        list1.add(666);
        list1.add(777);
        list1.add(345);
        System.out.println(list1.size());
        list1.remove(1);
        System.out.println(list1.size());
    }
}
