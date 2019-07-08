package Jvm;

class Person {
    private static volatile Person person;

    private Person() {
    }

    ;

    public static Person getPerson() {
        if (person == null) {
            synchronized (Person.class) {
                if (person == null) {
                    person = new Person();
                }
            }
        }
        return person;
    }
}

public class DoubleCheck {
    public static void main(String[] args) {

    }
}
