package Jvm;
class Test01{
    private static Test01 test;
    public void show(){
        System.out.println("i'm live");
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("自我拯救");
        test=this;
    }
}
public class Test {
    public static void main(String[] args) {
    Test01 test=new Test01();
    test=null;
    System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(test!=null){
        test.show();
    }else {
        System.out.println("dead!!!");
    }
    }
}
