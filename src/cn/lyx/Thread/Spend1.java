package Thread;

/**
 * Created by lyx on 2019/4/14.
 */
public class Spend1 implements Runnable{
    private House1 house1;

    public Spend1(House1 house1) {
        this.house1 = house1;
    }

    public void run(){
        while(true) {
                house1.getGoods();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
