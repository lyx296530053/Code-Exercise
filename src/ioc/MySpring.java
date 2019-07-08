package ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by lyx on 2019/4/9.
 */
public class MySpring {
    //设计一个方法帮我控制对象创建
    //需要参数名 String 类全名
    public Object getBean(String className){
        Object obj=null;
        Scanner input=new Scanner(System.in);
        System.out.println("请给"+className+"类对象赋值");
        try {
            //获取方法传递进来的参数对应的类
            Class cls=Class.forName(className);
            //通过Class创建一个对象
            obj=cls.newInstance();
            // 做一个自动DI植入，对象中所有值
            Field[] fields=cls.getDeclaredFields();
            for (Field field:fields
                 ) {
                String name=field.getName();
                String firstLetter=name.substring(0,1).toUpperCase();//属性字母变大写
                String endLetter=name.substring(1);//属性除了首字母之外的其他字母
                StringBuilder builder=new StringBuilder("set");
                builder.append(firstLetter);
                builder.append(endLetter);
                //获取field对应的数据类型 寻找set方法时传递参数用
                Class fieldClass=field.getType();
                //通过处理好的set方法名寻找泪中的set方法
                Method setMethod=cls.getMethod(builder.toString(),fieldClass);
                System.out.println("请给"+name+"属性赋值");
                String value =input.nextLine();
                Constructor con=fieldClass.getConstructor(String.class);
                setMethod.invoke(obj,con.newInstance(value));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
