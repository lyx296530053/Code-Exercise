package Jvm;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Teacher implements Cloneable {
    private String name;
    private Integer age;
    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student implements java.io.Serializable {
    private String name;
    private Integer age;
    private Teacher teacher;


    public Student(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public Student cloneObject() throws IOException, ClassNotFoundException {
        ByteOutputStream bos = new ByteOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.getBytes());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Student) ois.readObject();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

class Student01 implements Cloneable {
    private String name;
    private Integer age;
    private Teacher teacher;
    public Student01(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

class Student02 implements Cloneable {
    private String name;
    private Integer age;
    private Teacher teacher;

    public Student02(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    @Override
    protected Student02 clone() throws CloneNotSupportedException {
        Student02 temp = (Student02) super.clone();
        temp.teacher = (Teacher) this.teacher.clone();
        return temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

public class Serializable {
    public static void main(String[] args) throws Exception {
//    Teacher teacher=new Teacher("lyx",12);
//    Student student=new Student("abc",19,teacher);
//       Student01 clone = (Student01)student.clone();
//        System.out.println(clone==student);
       // System.out.println(clone.getTeacher()==student.getTeacher());
//            Student student1=student.cloneObject();
//            System.out.println(student1);
//            System.out.println(student);
//            System.out.println("=================");
//        System.out.println(student1.getTeacher()==student.getTeacher());
//        System.out.println(student==student1);
        Teacher teacher = new Teacher("lxy", 17);
        Student01 student = new Student01("abc", 12, teacher);
        Student01 clone = (Student01) student.clone();
        System.out.println(student == clone);
        System.out.println(student.getTeacher()==clone.getTeacher());
    }
}

