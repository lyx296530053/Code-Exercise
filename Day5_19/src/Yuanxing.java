abstract class People{
    abstract People get();
}
class Proxy extends People {
    private String name;
    public Proxy(String name) {
        this.name = name;
    }
    @Override
    People get() {
        return new Proxy(name);
    }
    @Override
    public String toString() {
        return "Proxy{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class Yuanxing {
    public static void main(String[] args) {
        People people=new Proxy("lyx");
        People people1 = people.get();
        System.out.println(people1);
    }
}
