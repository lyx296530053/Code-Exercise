package Design;

abstract class Person {
    abstract Person myClone();
}

class People extends Person {
    String name;

    public People(String name) {
        this.name = name;
    }

    @Override
    Person myClone() {
        return new People(name);
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class test {
    public static void main(String[] args) {
        Person p=new People("woaini");
        Person person = p.myClone();
        System.out.println(person.toString());
    }
}
