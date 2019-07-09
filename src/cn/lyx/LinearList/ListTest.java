package LinearList;

/**
 * Created by lyx on 2019/4/2.
 */
public class ListTest {
    public static void main(String[] args){
    List list=new LinkList();
    list.add(123);
    list.add(456);
    list.add(789);
    list.add(111);
    list.add(222);
    list.add(2,666);
    list.remove(2);
    System.out.println(list.size());
    list.show();
    }
}
