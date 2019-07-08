import java.util.concurrent.Exchanger;

public class ExchangerTset {
    public static void main(String[] args) {
        Exchanger<String> exchanger=new Exchanger<>();
        new Thread(()->{
            try {
                String woaini = exchanger.exchange(Thread.currentThread().getName()+"woaini");
                System.out.println(woaini);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            String nihaoa = exchanger.exchange(Thread.currentThread().getName()+"nihaoa");
            System.out.println(nihaoa);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
