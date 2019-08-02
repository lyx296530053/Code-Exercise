package cn.lyx.queue;

import java.util.Iterator;

public class Test {
    @org.junit.Test
    public void test(){
        ArrayQueue queue=new ArrayQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
