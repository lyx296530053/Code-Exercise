class House{
    private  String name;
    private  int count;
    public  synchronized void set(String name){
        if(count>0){
            System.out.println("有车");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + "生产了一个" + name);
            this.name = name;
            count = count + 1;
            notifyAll();
        }


    }
    public  synchronized void get(){
            if(count>0){
                System.out.println(Thread.currentThread().getName()+"拿走了一个"+this.name);
                count=count-1;
            }else {
                System.out.println(Thread.currentThread().getName() + "快去生产");
                notifyAll();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
class Produce implements Runnable{
private  House house;

    public Produce(House house) {
        this.house = house;
    }

    @Override
    public void run() {
        while(true) {
            house.set("奔驰戴克");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Customer1 implements Runnable{
private  House house;

    public Customer1(House house) {
        this.house = house;
    }

    @Override
    public void run() {
        while (true) {
            house.get();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class SpendAndProduce {
    public static void main(String[] args) {
        House house=new House();
            Thread thread=new Thread(new Produce(house),"生产者");
        Thread thread1=new Thread(new Produce(house),"生产者1");
        Thread thread2=new Thread(new Produce(house),"生产者2");
            thread.setPriority(10);
        thread1.setPriority(10);
        thread2.setPriority(10);
        thread.start();
        thread1.start();
        thread2.start();
        for (int i = 0; i < 4; i++) {
            new Thread(new Customer1(house)).start();
        }

    }
}
