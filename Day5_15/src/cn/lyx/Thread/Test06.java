package Thread;

class CAS{
    synchronized static int cas (Automic var1){
        int old;
        do {
            old=var1.getValue();
        } while (!compareAndSwap(var1,old));
        var1.setValue(old+1);
        return old;
    }
    static boolean compareAndSwap(Automic o,int a){
        if(o.getValue()==a){
            return true;
        }else return false;
    }
}

class Automic{
   private int value=0;
    int getandIncrease(){
        return CAS.cas(this)+1;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
public class Test06 {
    public static void main(String[] args) {
        Automic automic=new Automic();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println( automic.getandIncrease());
                }
            }).start();
        }
    }
}
