package LinkList;

public class Test {
    public static void main(String[] args) {
        LinkedListes linkedList=new LinkedListes();
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(1);
        System.out.println(linkedList.size());
        linkedList.show();
        System.out.println();
        linkedList.delete(4);
        System.out.println(linkedList.size());
        linkedList.show();
        System.out.println();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        System.out.println(linkedList.size());
        linkedList.show();
    }
}
