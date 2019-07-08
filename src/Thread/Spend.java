package Thread;

/**
 * Created by lyx on 2019/4/12.
 */
public class Spend extends Thread{
    private String name1;

    public Spend(String name) {
        this.name1 = name;
    }

    public void run(){
        while(true) {
            House house = House.getInstance();
            house.getGoods();
            System.out.println(name1+"拿走了一件商品");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
