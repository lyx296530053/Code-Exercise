package Thread;

import java.util.ArrayList;

/**
 * Created by lyx on 2019/4/12.
 */
public class House {
    private final static House house=new House();
    private void House(){};
    public static House getInstance(){
        return house;
    }
    private ArrayList<String > list=new ArrayList<>();

    public void setGoods(){
        if(list.size()<20){
            list.add("a");
        }else {
            try {
                notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void getGoods(){
        if(list.size()>0){
            list.remove(0);
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
