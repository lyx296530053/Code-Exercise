package Collection;

import java.util.LinkedList;
import java.util.List;

public class LinkListTest {
    public static void main(String[] args){
        List list=new LinkedList();
        list.add("lyx");
        list.add(123);
        list.add(new person("lll",666));
        System.out.println(list.get(2));
        System.out.println(list.contains(new person("lll",666)));

    }
}
