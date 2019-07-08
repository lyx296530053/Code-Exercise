package ThreadTest;

import java.util.Timer;
import java.util.TimerTask;

class Mytask extends TimerTask{

    @Override
    public void run() {
        System.out.println("nihao");
    }
}
public class TimeTest {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new Mytask(),2000,10);
    }
}
