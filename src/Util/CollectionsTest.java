package Util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyx on 2019/4/14.
 */
public class CollectionsTest {
    public static void main(String[] args){
        List list=new LinkedList();
        Collections.addAll(list,"a",1,"b",2,"c",3);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
