package Test_1;

import java.io.Serializable;

public class Person implements Serializable {
    private static final Integer serialVersionUID=1721381;
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Reflact.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
