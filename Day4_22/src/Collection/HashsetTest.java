package Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

class People{
    private String name;
    private Integer age;

    public People(String name, Integer age) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (name != null ? !name.equals(people.name) : people.name != null) return false;
        return age != null ? age.equals(people.age) : people.age == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class HashsetTest {
    public static void main(String[] args){
        HashSet set=new HashSet();
        set.add("lyx");
        set.add(123);
        set.add(new People("qwe",666));
        set.add(new People("qwe",666));
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        LinkedHashSet linkedHashSet=new LinkedHashSet();
        linkedHashSet.add("qqq");
        linkedHashSet.add("www");
        linkedHashSet.add("eee");
        Iterator iterator1=linkedHashSet.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
