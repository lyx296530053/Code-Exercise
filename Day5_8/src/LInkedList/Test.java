package LInkedList;

public class Test {
    public static void main(String[] args) {
        IList list=new MyLinkedList();
        list.addFirst(1213);
        list.addFirst(1552);
        list.addFirst(71);
        list.addFirst(null);
        System.out.println(list.size());
        list.printLink();
       list.remove(1552);
       list.printLink();
    }
}
