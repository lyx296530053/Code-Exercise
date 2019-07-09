package LinearList;

/**
 * Created by lyx on 2019/4/2.
 */
public class LinkList implements List <Integer>{
    private Node head=new Node();
    private int size;
    private class Node{
        Object data;
        Node next;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    @Override
    public void add(Integer integer) {
        this.add(size,integer);
    }

    @Override
    public void add(int n, Integer integer) {
        Node p=head;
        for(int i=0;i<n;i++){
            p=p.next;
        }
    Node newNode=new Node();
    newNode.data=integer;
    newNode.next=p.next;
    p.next=newNode;
    size++;
    }

    @Override
    public void remove(int t) {
        Node p=head;
        for(int i=0;i<t;i++){
            p=p.next;
        }
        p.next=p.next.next;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void show() {
        Node p=head;
        for(int i=0;i<size;i++){
            p=p.next;
            System.out.print(p.data+" ");
        }
    }
}
