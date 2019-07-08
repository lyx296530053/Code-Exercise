package Test;

class Teacher {
    public Teacher() {
    }

    public Teacher(Teacher teacher) {
    }
}

class Person2 {
    String name;
    Teacher teacher;

    public Person2() {
    }

    public Person2(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public Person2(Person2 person2) {
        name = new String(person2.name);
        teacher = new Teacher(person2.teacher);
    }
}

public class Test02 {
    public static void main(String[] args) {
        Person2 p = new Person2("lyx", new Teacher());
        Person2 p1 = new Person2(p);
        System.out.println(p == p1);//false
        System.out.println(p.name);//lyx
        System.out.println(p1.name);
        p.name = "abc";
        System.out.println(p.name);//abc
        System.out.println(p1.name);//lyx
        System.out.println(p.teacher == p1.teacher);//false
    }
}
