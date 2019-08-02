package cn.lyx.stack;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    @org.junit.Test
    public void test(){
       LinkedListStack arrayStack=new LinkedListStack();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        Iterator iterator = arrayStack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        try {
            Object pop = arrayStack.pop();
            System.out.println(pop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
