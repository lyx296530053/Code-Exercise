interface Eat{//核心业务
     void eat();
}
class people implements Eat{//真实要求

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
class shop implements Eat{
private Eat e;

    public shop(Eat e) {
        this.e = e;
    }

    @Override
    public void eat() {
        System.out.println("开始");
        this.e.eat();
        System.out.println("结束");
    }
}
class factory {
    public static shop get(){
        return new shop(new people());
    }
}
public class ReflectTest {
    public static void main(String[] args) {
        factory.get().eat();
    }
}
