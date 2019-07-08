public class MyLinkedList implements IList {
    private class Node {
        private Node prev;
        Object data;
        private Node next;

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "prev=" + prev +
                    ", data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;
    private Node last;
    private int size;

    @Override
    public void addFirst(Object data) {
       Node temp=head;
       Node newNode=new Node(null,data,head);
       head=newNode;
       if(head==null){
           last=newNode;
       }else{
           temp.prev=newNode;
       }
       size++;
    }

    @Override
    public void addLast(Object data) {
        Node temp=this.last;
        Node newNode=new Node(temp,data,null);
        this.last=newNode;
        if(this.head==null){
            this.head=newNode;
        }else {
            temp.next=newNode;
        }
        size++;
    }
    public void unlink(Node o){
        Object element=o.data;
        Node prev=o.prev;
        Node next=o.next;
        if(prev==null){
            head=next;
        }else{
            prev.next=next;
            o.prev=null;
        }
        if(next==null){
            last=prev;
        }else {
            next.prev=prev;
            o.next=null;
        }
        o.data=null;
        size--;
    }
    @Override
    public void remove(Object data) {
    if(data==null){
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data==null){
                unlink(temp);
            }
        }
    }else {
        for(Node temp=head;temp!=null;temp=temp.next){
            if(data.equals(temp.data)){
                unlink(temp);
            }
        }
    }
    }

    @Override
    public void printLink() {
        for(Node temp=head;temp!=null;temp=temp.next){
            System.out.println(temp.data);
        }
    }

    @Override
    public int size() {
        return size;
    }
}

