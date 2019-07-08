package Ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;


class MySpring {
    public Object getBean(String className) {
        Object obj=null;
        try {
            System.out.println("请为" + className + "类赋值");
            Class cls = Class.forName(className);
            obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                String s = name.substring(0, 1).toUpperCase();
                String s1 = name.substring(1);
                StringBuilder sb = new StringBuilder("set");
                sb.append(s);
                sb.append(s1);
                Class type = field.getType();
                Method declaredMethod = cls.getDeclaredMethod(sb.toString(), type);
                System.out.println("给" + name + "属性赋值");
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                Constructor constructor = type.getConstructor(String.class);
                declaredMethod.invoke(obj, constructor.newInstance(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}

public class Test {
    public static void main(String[] args) {
        MySpring mySpring = new MySpring();
        Person person = (Person) mySpring.getBean("Ioc.Person");
        System.out.println(person);
    }
}
