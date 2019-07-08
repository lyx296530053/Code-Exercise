class Person {
    private volatile static Person p;

    private Person() {
    }
    public static Person getPerson() {
        if (p == null) {
            synchronized (Person.class) {
                if (p == null) {
                    Person p = new Person();
                }
            }
        }
        return p;
    }
}

class Person01{
    private static final Person01 p=new Person01();
    private Person01(){}
}
class Person02{
    private Person02(){}
    private static class get{
        private static final Person02 p=new Person02();
    }
    public static Person02 getPerson02(){
        return get.p;
    }
}
enum Person03{
    SIGNAL;
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
public class Signal {
    public static void main(String[] args) {
    }
}
