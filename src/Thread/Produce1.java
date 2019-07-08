package Thread;

/**
 * Created by lyx on 2019/4/14.
 */
public class Produce1 implements Runnable{
    private House1 house1;

    public Produce1(House1 house1) {
        this.house1 = house1;
    }

    public void run(){
        while(true) {
            house1.setGoods();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
