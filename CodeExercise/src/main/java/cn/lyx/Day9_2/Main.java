package cn.lyx.Day9_2;


import java.util.List;

class  ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {

    public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
            if (head1 == null || head2 == null) {
                return null;
            }
            ListNode loop1 = getLoopNode(head1);
            ListNode loop2 = getLoopNode(head2);
            if (loop1 == null && loop2 == null) {
                return noLoop(head1, head2);
            }
            if (loop1 != null && loop2 != null) {
                return bothLoop(head1, loop1, head2, loop2);
            }
            return null;
        }
        public static ListNode getLoopNode (ListNode head){
            if (head.next.next == null) {
                return null;
            }
            ListNode first = head;
            ListNode last = head.next.next;
            boolean flag = false;
            while (last != null) {
                if (first == last) {
                    first = head;
                    flag = true;
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

        public static ListNode noLoop (ListNode head1, ListNode head2){
            if (head1 == null || head2 == null) {
                return null;
            }
            ListNode cur1 = head1;
            ListNode cur2 = head2;
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

        public static ListNode bothLoop (ListNode head1, ListNode loop1, ListNode head2, ListNode loop2){
            ListNode cur1 = head1;
            ListNode cur2 = head2;
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
    }