class Student{
    String name;

    public Student(String name) {
        this.name = name;
        System.out.println(this.name);
    }
}
public class Person {
    public static void main(String[] args) {
        new Student("lyx");
    }
}

