package Compare;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class  Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
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

//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Person){
//            Person p=(Person) o;
//            if(this.age>p.age){
//                return 1;
//            }else if(this.age<age){
//                return -1;
//            }else {
//                return this.name.compareTo(p.name);
//            }
//        }
//        throw  new RuntimeException("传入数据不一致");
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Natural {
    public static void main(String[] args) {
        Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if ((o1 instanceof Person) && (o2 instanceof Person)) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    if (p1.getName().equals(p2.getName())) {
                        return Double.compare(p1.getAge(), p2.getAge());
                    } else {
                        return p1.getName().compareTo(p2.getName());
                    }
                }
                throw  new RuntimeException("输入数据类型不一致");
            }
        };
        TreeSet hashSet=new TreeSet(comparator);
        hashSet.add(new Person("a",22));
        hashSet.add(new Person("a",12));
        hashSet.add(new Person("a",32));
        Iterator iterator=hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
