package Thread;

/**
 * Created by lyx on 2019/4/15.
 */
class Bank {
    private Bank(){};
    private final static Bank bank=new Bank();
    public static Bank getBank(){
        return bank;
    }
    private int value=0;
    public synchronized void setMoney(){
            notifyAll();
            value +=1000;
            System.out.println(Thread.currentThread().getName()+":余额为" + value);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    }
class Customer implements Runnable{
    private  int money=3000;
    @Override
    public void run() {
      Bank bank=Bank.getBank();
    while(money>0){
        money-=1000;
          bank.setMoney();
      }
      if(money==0)return;
    }
}
public class BankTest {
    public static void main(String[] args){
       Customer customer=new Customer();
       Customer customer1=new Customer();
       Customer customer2=new Customer();
       Thread thread=new Thread(customer,"one");
       Thread thread1=new Thread(customer1,"two");
       Thread thread2=new Thread(customer2,"three");
       thread.start();
       thread1.start();
        thread2.start();
    }

}
