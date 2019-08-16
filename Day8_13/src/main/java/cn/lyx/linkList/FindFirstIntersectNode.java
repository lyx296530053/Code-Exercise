package cn.lyx.linkList;

public class FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 两链表相交
     * 判断两个链表是否有环
     * 一、一个无环一个有环一定不相交
     * 二、两个无环则找交点
     * 方法：假如链表1长a+c链表2长b+c则a+c+b=b+c+a,
     * 所以让第一个链表走完接着走链表2，链表二走完接着走链表一
     * 两个结点一定会相遇
     * 三、要是两个都有环
     * 则分为两个入环点相同不相同，
     * 1：如果两个链表入环点相同，则可以看成是链表头部到入环点的两个无环的链表相交，和第一种情况一样
     * 2：如果不同，则让链表一从环点开始遍历如果找完整个环都没有遇到链表二入环点则不相交，反之相交
     * @return 返回相交点
     */
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    public static Node getLoopNode(Node head) {
        if (head.next.next == null) {
            return null;
        }
        Node first = head;
        Node last = head.next  ;
        boolean flag = false;
        while (last.next.next != null) {
            if (first == last) {
                first=first.next;
                flag = true;
                last = head;
                while (first != last) {
                    last = last.next;
                    first = first.next;
                }
                break;
            }
            first = first.next;
            last = last.next.next;
        }
        if (flag) {
            return first;
        } else return null;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null) {
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = head1;
        cur2 = head2;
        while (cur1 != cur2) {
            cur1 = (cur1 == null) ? head2 : cur1.next;
            cur2 = (cur2 == null) ? head1 : cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = head1;
        Node cur2 = head2;
        if (loop1 == loop2) {
            while (cur1 != cur2) {
                cur1 = (cur1 == loop1) ? head2 : cur1.next;
                cur2 = (cur2 == loop2) ? head1 : cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}
