package Thread;

public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            int i=10;
            @Override
            public void run() {
                while(i>0){
                    System.out.println(i--);
                    if(i==5){
                        Thread.yield();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        Thread thread=new Thread(new Runnable() {
            int i=10;
            @Override
            public void run() {
                while(i>0){
                    System.out.println(i--);
                    }
                }
        });
        thread.start();
        System.out.println("GG");
        thread.join();
        System.out.println("hahaha");
    }
}
