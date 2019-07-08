package LinkList;

public class LinkedListes implements List {

    private class Node {
        Node pre;
        Object data;
        Node aft;

        public Node(Node pre, Object data, Node aft) {
            this.pre = pre;
            this.data = data;
            this.aft = aft;
        }
    }

    private Node head;
    private Node next;
    private int size;

    @Override
    public void add(Object data) {
        Node temp = next;
        Node newNode = new Node(temp, data, null);
        next = newNode;
        if (head == null) {
            head = newNode;
        } else {
            temp.aft = newNode;
        }
        size++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        Node newNode = new Node(null, data, temp);
        head = newNode;
        if (next == null) {
            next = newNode;
        } else {
            head.pre = newNode;
        }
        size++;
    }

    @Override
    public void delete(Object data) {
        if (data == null) {
            for (Node head = this.head; head != null; head = head.aft) {
                if (head.data == null) {
                    unlike(head);
                }
            }
        } else {
            for (Node head = this.head; head != null; head = head.aft) {
                if (head.data.equals(data)) {
                    unlike(head);
                }
            }
        }
        size--;
    }


    private void unlike(Node node) {
        Node pre = node.pre;
        Node aft = node.aft;
        if (pre == null) {
            head = aft;
        } else {
            pre.aft = aft;
            node.pre = null;
        }
        if (aft == null) {
            next = pre;
        } else {
            aft.pre = pre;
            node.aft = null;
        }
        node.data = null;
    }

    @Override
    public void show() {
        for (Node head=this.head; head!=null ; head=head.aft) {
            System.out.print(head.data);
        }
    }

    @Override
    public int size() {
        return size;
    }
}
