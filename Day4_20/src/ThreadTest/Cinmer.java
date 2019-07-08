package ThreadTest;

import java.util.ArrayList;
import java.util.List;
class Customer implements Runnable{
 List list=new ArrayList();
private Server server;

    public Customer(List list, Server server) {
        this.list = list;
        this.server = server;
    }

    @Override
    public void run() {
        synchronized (server) {
            server.set(list);
        }
    }
}
class Server{
     List list1 =new ArrayList<>();

    public Server(List list) {
        list1 = list;
    }

    public  void set(List list){
            ArrayList copy=new ArrayList();
            copy.addAll(list1);
            copy.removeAll(list);
            if(list1.size()-copy.size()==list.size()){
                System.out.println(Thread.currentThread().getName()+"：购票成功");
                list1=copy;
            }else {
                System.out.println(Thread.currentThread().getName()+"购票失败");
                return;
            }
    }

}
public class Cinmer {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Server server=new Server(list);
        List list1=new ArrayList();
        list1.add(4);
        list1.add(5);
        list1.add(3);
        List list2=new ArrayList();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        Thread thread=new Thread(new Customer(list1,server),"老王");
        Thread thread1=new Thread(new Customer(list2,server),"老李");
        thread1.setPriority(6);
        thread.start();
        thread1.start();
    }
}
