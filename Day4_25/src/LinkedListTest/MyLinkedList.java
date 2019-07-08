package LinkedListTest;

public class MyLinkedList implements Ilist{
    private class Node<E>{
        Node<E> prev;
        E data;
        Node<E> next;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data= data;
            this.next = next;
        }
    }
    Node head;
    Node last;
    int size;
    @Override
    public void add(Object data) {
        Node temp=last;
        Node newNode=new Node(temp,data,null);
        last=newNode;
        if(head==null){
            head=newNode;
        }else{
            temp.next=newNode;
        }
        size++;
    }

    @Override
    public void remove(Object data) {
       for(Node temp=head;temp!=null;temp=temp.next){
           if(data.equals(temp.data)){
               if(temp.next==null){
                   temp.prev.next=null;
                   temp.prev=null;
               }else{
                   temp.prev.next=temp.next;
                   temp.next.prev=temp.prev;
                   temp.next=null;
                   temp.prev=null;
               }
               size--;
           }
       }
    }

    @Override
    public void set(Object data) {

    }

    @Override
    public void get(Object data) {

    }

    @Override
    public void printList() {
    for(Node temp=head;temp!=null;temp=temp.next){
        System.out.println(temp.data);
    }
    }

    @Override
    public int size() {
        return size;
    }
}
