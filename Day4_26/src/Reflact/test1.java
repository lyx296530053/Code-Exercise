package Reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class cls=Person.class;
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---------------------");
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("--------------------------");
        Method[] methods = cls.getMethods();;
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("--------------------------");
        Constructor[] constructor = cls.getConstructors();
        for (Constructor constructor1 : constructor) {
            System.out.println(constructor1);
        }
    }
}
