package cn.lyx.Test;

public class Test {
    @org.junit.Test
    public void test(){
        for (int i = 2017; ; i++) {
            if(i%8==0&&i%6==0&&i%9==0){
                System.out.println(i);
                break;
            }
        }
    }
}
