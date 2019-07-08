public class Test {
    public static void main(String[] args) {
        IList list=new MyLinkedList();
        list.addLast(1213);
        list.addLast(1552);
        list.addLast(71);
        list.addLast(null);
        System.out.println(list.size());
        list.printLink();
        list.remove(1552);
        list.printLink();
    }
}
