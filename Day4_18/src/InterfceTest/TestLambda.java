package InterfceTest;

interface Lambda{
    void print();
}
public class TestLambda {

    public static void main(String[] args) {
        Lambda lambda = new Lambda() {
            @Override
            public void print() {
                System.out.println("11111");
            }
        };
        lambda.print();
        Lambda lambda1=()->System.out.println("222222");
        lambda1.print();
    }
}

