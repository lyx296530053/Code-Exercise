package Reflect;

import BaseClass.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
         Class cls= Test.class;
//       Field[] fields=cls.getDeclaredFields();
//        for(Field f:fields){
//            System.out.println(f);
//        }
//        Method[] methods=cls.getDeclaredMethods();
//        for (Method m:methods
//             ) {
//            System.out.println(m);
//        }
//        Class superclass = cls.getSuperclass();
//        System.out.println(superclass);
//        Annotation[] annotations = cls.getAnnotations();
//        for (Annotation a:annotations
//             ) {
//            System.out.println(a);
//        }
        Test t = (Test) cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(t,"lyx");
        System.out.println(name.get(t));
        Method show = cls.getDeclaredMethod("show");
        show.setAccessible(true);
        show.invoke(t);
        Constructor declaredConstructor = cls.getDeclaredConstructor(Integer.class,String.class,String.class);

        Test o = (Test)declaredConstructor.newInstance(12, "lll", "male");
        System.out.println(o);
    }
}
