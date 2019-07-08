package Thread;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class Read implements Runnable{
    static CopyOnWriteArrayList arrayList=new CopyOnWriteArrayList();
    static {
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(789);
    }
    @Override
    public void run() {
        Iterator iterator=arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            arrayList.add("aaa");
        }
    }
}
public class Test07 {
    public static void main(String[] args) {
        Read read=new Read();
        for (int i = 0; i < 10; i++) {
            new Thread(read).start();
        }
    }
}