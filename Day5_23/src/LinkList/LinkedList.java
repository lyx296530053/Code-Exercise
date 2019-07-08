package LinkList;

public class LinkedList implements List {
    private class Node {
        Object data;
        Node aft;

        public Node() {
        }

        public Node(Object data, Node aft) {
            this.data = data;
            this.aft = aft;
        }
    }

    private Node head=new Node();
    private Node nxxt;
    int size=0;

    @Override
    public void add(Object data) {
        this.add(size, data);
    }

    public void add(int n, Object data){
        Node temp=head;
        for (int i = 0; i < size; i++) {
            temp=temp.aft;
        }
        Node newNode=new Node();
        newNode.data=data;
        newNode.aft=temp.aft;
        temp.aft=newNode;
        size++;
    }

    @Override
    public void delete(Object data) {

    }

    @Override
    public void show() {
        Node temp=head;
        for (int i = 0; i < size; i++) {
            temp=temp.aft;
            System.out.print(temp.data+" ");
        }
    }

    @Override
    public int size() {
        return size;
    }
}
