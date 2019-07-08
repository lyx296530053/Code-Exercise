package Reflect;

import java.lang.reflect.Field;

/**
 * Created by lyx on 2019/4/9.
 */
public class ChangeStringValue {
    public static  void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str=new String("abc");
        System.out.println(str);
        Class cls=str.getClass();
        Field fie=cls.getDeclaredField("value");
        fie.setAccessible(true);
        char[] temp=(char[])fie.get(str);
        temp[0]='黎';
        temp[1]='燕';
        temp[2]='翔';
        System.out.println(str);
    }
}
