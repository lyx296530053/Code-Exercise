package ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by lyx on 2019/4/10.
 */
public class MySpring4_10 {
   public  Object getBean(String temp){
       Object obj=null;
       Scanner input=new Scanner(System.in);
       System.out.println("请给"+temp+"类对象赋值");
       try {
           Class cls=Class.forName(temp);
           obj=cls.newInstance();
           Field[] fields=cls.getDeclaredFields();
           for (Field f:fields
                ) {
               String name=f.getName();
               String firstLetter=name.substring(0,1).toUpperCase();
               String endLetter=name.substring(1);
               StringBuilder builder= new StringBuilder("set");
               builder.append(firstLetter);
               builder.append(endLetter);
               Class fClass=f.getType();
               Method getMethod=cls.getMethod(builder.toString(),fClass);
               System.out.println("请给"+name+"属性赋值");
               String value =input.nextLine();
               Constructor con=fClass.getConstructor(String.class);
               getMethod.invoke(obj,con.newInstance(value));
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return obj;
   }
}
