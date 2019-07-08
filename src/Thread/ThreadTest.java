package Thread;

/**
 * Created by lyx on 2019/4/12.
 */
public class ThreadTest {
    public static void main(String[] args) {
//      Window w1=new Window("西安北站");
//      Window w2=new Window("西安南站");
//      Window w3=new Window("西安东站");
//      Window w4=new Window("西安西站");
//      w1.start();
//      w2.start();
//      w3.start();
//      w4.start();
        House1 house1=new House1();
        Produce1 p1=new Produce1(house1);
        Spend1 spend1=new Spend1(house1);
        Spend1 spend2=new Spend1(house1);
        Thread thread=new Thread(p1,"生产者");
        thread.start();
        thread.setPriority(10);
        new Thread(spend1,"消费者1").start();
        new Thread(spend2,"消费者2").start();

    }
}
