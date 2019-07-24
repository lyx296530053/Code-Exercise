package ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by lyx on 2019/4/15.
 */
public class MySpring4_14 {
    public Object getBean(String className) {
        System.out.println("请给" + className + "对象赋值");
        Scanner input = new Scanner(System.in);
        Object obj = null;
        try {
            Class cls = Class.forName(className);
            obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields
                    ) {
                String fName = f.getName();
                String old = fName.substring(0, 1).toUpperCase();
                String aft = fName.substring(1);
                StringBuilder stringBuilder = new StringBuilder("set");
                stringBuilder.append(old);
                stringBuilder.append(aft);
                Class getType = f.getType();
                Method method = cls.getDeclaredMethod(stringBuilder.toString(), getType);
                Constructor constructor = getType.getDeclaredConstructor(String.class);
                System.out.println("请给" + fName + "属性赋值");
                String value = input.nextLine();
                method.invoke(obj, constructor.newInstance(value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}