package cn.lyx.Josepfu;

class SingleLink {
    private class Node {
        int num;
        Node next;

        public Node(int num) {
            this.num = num;
        }
    }

    Node head = null;

    public void add(int num) {
        Node temp = new Node(-1);
        for (int i = 1; i <= num; i++) {
            Node node = new Node(i);
            if (i == 1) {
                head = node;
                head.next = head;
                temp = head;
            } else {
                temp.next = node;
                temp.next.next = head;
                temp = temp.next;
            }
        }
    }

    public void show() {
        Node temp = head;
        while (true) {
            System.out.println(temp.num);
            temp = temp.next;
            if (temp == head) {
                break;
            }
        }
    }

    void josepfu(int num, int start) {
        Node temp = head;
        while (true) {
            if (temp.next == head) {
                break;
            }
            temp = temp.next;
        }
        for (int i = 0; i < start - 1; i++) {
            head = head.next;
            temp = temp.next;
        }
        while (true) {
            if (temp == head) {
                break;
            }
            for (int i = 0; i < num - 1; i++) {
                head = head.next;
                temp = temp.next;
            }
            System.out.print(head.num + "-");
            head = head.next;
            temp.next = head;
        }
        System.out.println(head.num);
    }

}

public class Test {
    public static void main(String[] args) {
        SingleLink singleLink = new SingleLink();
        singleLink.add(5);
        singleLink.josepfu(2, 1);
    }
}
