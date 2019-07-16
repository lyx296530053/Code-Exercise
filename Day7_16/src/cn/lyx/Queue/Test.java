package cn.lyx.Queue;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        QueueByLinkList<Integer> queue=new QueueByLinkList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.size());
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
