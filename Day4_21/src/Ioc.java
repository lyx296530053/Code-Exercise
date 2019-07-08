import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

class MySping{
    public Object getBean(String className){
        System.out.println("请为"+className+"类赋值");
        Scanner input=new Scanner(System.in);
        Object obj=null;
        try {
            Class cls=Class.forName(className);
            obj=cls.newInstance();
            Field[] fields=cls.getDeclaredFields();
            for (Field f:fields
                 ) {
                String name=f.getName();
                String old = name.substring(0, 1).toUpperCase();
                String aft=name.substring(1);
                StringBuilder stringBuilder=new StringBuilder("set");
                stringBuilder.append(old);
                stringBuilder.append(aft);
                Class type = f.getType();
                Method method=cls.getDeclaredMethod(stringBuilder.toString(),type);
                System.out.println("请给"+f.getName()+"属性赋值");
                Constructor constructor=type.getConstructor(String.class);
                String value = input.next();
                method.invoke(obj,constructor.newInstance(value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
public class Ioc {
    public static void main(String[] args) {
        MySping mySping=new MySping();
        Person person = (Person) mySping.getBean("Person");
        System.out.println(person);
    }
}
