package Every;

class Person {
    private String name = "hello";
    int age = 0;
}

public class Test extends Person {
    public String a;
    public static void main(String[] args) {
        Person p = new Test();
    }
}
