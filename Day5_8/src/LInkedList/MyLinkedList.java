package LInkedList;

public class MyLinkedList implements IList {
    private class Node {
        Node per;
        Object value;
        Node next;

        public Node(Node per, Object value, Node aft) {
            this.per = per;
            this.value = value;
            this.next = aft;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "per=" + per +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;
    private Node last;
    private int size;

    @Override
    public void addFirst(Object data) {
        Node temp = head;
        Node newNode = new Node(null, data, temp);
        head = newNode;
        if (temp == null) {
            last = newNode;
        } else {
            temp.per = newNode;
        }
        size++;
    }

    @Override
    public void addLast(Object data) {
        Node temp = last;
        Node newNode = new Node(temp, data, null);
        last = newNode;
        if (head == null) {
            head = newNode;
        } else {
            temp.next = newNode;
        }
        size++;
    }

    public void unlink(Node node) {
        Node per = node.per;
        Node next = node.next;
        if (per == null) {
            head = next;
        } else {
            per.next = next;
            node.per = null;
        }
        if(next==null){
            last=per;
        }else {
            next.per=per;
            node.next=null;
        }
        node.value=null;
        size--;
    }

    @Override
    public void remove(Object data) {
        if (data == null) {
            for (Node temp = head; temp != null; temp = temp.next) {
                if (temp.value == null) {
                    unlink(temp);
                }
            }
        } else {
            for (Node temp = head; temp != null; temp = temp.next) {
                if (data.equals(temp.value)) {
                    unlink(temp);
                }
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printLink() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.println(temp.value);
        }
    }
}
