package ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

/**
 * Created by lyx on 2019/4/12.
 */
public class Myspring4_12 {
    public Object getBean(String className){
        System.out.println("请为"+className+"对象赋值");
        Scanner input=new Scanner(System.in);
        Object obj=null;
        try {
            Class cls=Class.forName(className);
            obj=cls.newInstance();
            Field[] fields=cls.getDeclaredFields();
            for (Field f:fields
                 ) {
                String name=f.getName();
                String firstLetter=name.substring(0,1).toUpperCase();
                String endLetter=name.substring(1);
                StringBuilder stringBuilder=new StringBuilder("set");
                stringBuilder.append(firstLetter);
                stringBuilder.append(endLetter);
                Class classType=f.getType();
                Method setMethod=cls.getDeclaredMethod(stringBuilder.toString(),classType);
                Constructor constructor=classType.getConstructor(String.class);
                System.out.println("请给"+f.getName()+"属性赋值");
                String value=input.nextLine();
                setMethod.invoke(obj,constructor.newInstance(value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
