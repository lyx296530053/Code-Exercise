package LinkedListTest;

public class MyLinkedList1 implements Ilist{
    private class Node{
        Node next;
        Object data;

        public Node() {
        }

        public Node(Node next, Object data) {
            this.next = next;
            this.data = data;
        }
    }
    private Node head;
    int size;
    @Override
    public void add(Object data) {
        Node newNode=new Node(null,data);
        head=newNode;
        head.next=newNode;

//     Node p=head;
//     for(int i=0;i<size;i++){
//         p=p.next;
//     }
//     Node newNode=new Node();
//     newNode.data=data;
//     newNode.next=p.next;
//     p.next=newNode;
//     size++;
    }

    @Override
    public void remove(Object data) {

    }

    @Override
    public void set(Object data) {

    }

    @Override
    public void get(Object data) {

    }

    @Override
    public void printList() {

    }

    @Override
    public int size() {
        return 0;
    }
}
