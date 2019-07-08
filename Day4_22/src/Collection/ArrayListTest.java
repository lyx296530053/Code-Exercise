package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
class person{
    private String name;
    private Integer age;

    public person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
      @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        person person = (person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return age != null ? age.equals(person.age) : person.age == null;
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
}
public class ArrayListTest {
    public static void main(String[] args){
        List list=new ArrayList();
        list.add("lyx");
        list.add(123);
        list.add(new person("lll",24));
//        for (Object o:list
//             ) {
//            System.out.println(o);
//        }
//        list.remove(new person("lll",24));
//        for (Object o :list
//                ) {
//            System.out.println(o);
//        }
        list.set(1,"qwe");
        for (Object o:list
             ) {
            System.out.println(o);
        }
        System.out.println(list.contains(new person("lll",24)));
        Object[] objects = list.toArray();
        for(int i=0;i<objects.length;i++) {
            System.out.println(objects[i]);
        }
        List<Object> objects1 = Arrays.asList(objects);
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
