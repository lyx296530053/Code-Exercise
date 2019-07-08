package IO;

import java.io.*;

class Person implements Serializable {
    private static  final Integer SerialVersionUID=123456;
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class ObjectStream {
    public static void main(String[] args) {
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("data.dat"));
            oos.writeObject(new String("lyx"));
            oos.writeObject(new Integer(123));
            oos.writeObject(new Person("aaa",7889));
            oos.flush();
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("data.dat"));
            String str=(String) ois.readObject();
            System.out.println(str);
            Integer inte=(Integer)ois.readObject();
            System.out.println(inte);
            Person person=(Person) ois.readObject();
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
