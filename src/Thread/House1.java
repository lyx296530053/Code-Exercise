package Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyx on 2019/4/14.
 */
public class House1 {

    List<Integer> list=new ArrayList<>();
    public synchronized void setGoods(){
        if(list.size()<20){
            list.add(1);
            notifyAll();
            System.out.println(Thread.currentThread().getName()+"生产了一件商品");
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void getGoods(){
        if(list.size()>0){
            list.remove(0);
            System.out.println(Thread.currentThread().getName()+"拿走了一件商品");
        }else {
            try {
                notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
