package Thread;

/**
 * Created by lyx on 2019/4/12.
 */
public class Produce extends Thread{
    private String name1;

    public Produce(String name) {
        this.name1 = name;
    }

    public void run() {
        while(true) {
            House house = House.getInstance();
            house.setGoods();
            System.out.println(name1+"生产了一件商品");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
