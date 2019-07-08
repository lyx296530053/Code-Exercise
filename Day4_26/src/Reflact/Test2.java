package Reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Class<Person> cls = Person.class;
        Person p =  cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"lyx");
        System.out.println(p.getName());
        System.out.println(name.get(p));
        Method getName = cls.getDeclaredMethod("getName");
        getName.setAccessible(true);
        Object invoke = getName.invoke(p);
        System.out.println(invoke);
        Constructor<Person> constructor = cls.getConstructor(String.class, Integer.class);
        Person person=constructor.newInstance("abc",123);
        System.out.println(person);
    }
}
