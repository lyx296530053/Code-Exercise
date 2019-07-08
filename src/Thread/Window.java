package Thread;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by lyx on 2019/4/12.
 */
public class Window extends Thread {
    private String windowName;

    public Window() {
    }
    public Window(String windowName) {
        this.windowName = windowName;
    }
    public void run(){
        this.sellTicket();
    }
    public  void sellTicket() {
        while (true) {
            System1 system = System1.getInstance();
            Ticket ticket = system.getTicket();
            if(ticket==null){
                System.out.println("售空");
                break;
            }
            System.out.println("从" + windowName+ "售出" + ticket.getStar() + "到" + ticket.getEnd() + "价格" + ticket.getPrice());
        }
    }
}
