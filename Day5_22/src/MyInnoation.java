import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Color{
    public enum color{READ,BILU,RED}
    color FruitColor() default color.READ;
}
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Name{
    String FruitName() default "";
}
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface address{
    String FruitAddress() default "";
}
class Apple{
    @Name(FruitName = "红富士")
    String name;
    @Color(FruitColor=Color.color.RED)
    String color;
    @address(FruitAddress = "陕西省西安市")
    String address;

    public Apple(String name, String color, String address) {
        this.name = name;
        this.color = color;
        this.address = address;
    }
}
public class MyInnoation {
    public static void get(Class clss){
        Class cls=clss;
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if(declaredField.isAnnotationPresent(Name.class)){
                Name annotation = declaredField.getAnnotation(Name.class);
                System.out.println(annotation.FruitName());
            }
            if(declaredField.isAnnotationPresent(Color.class)){
                Color annotation = declaredField.getAnnotation(Color.class);
                System.out.println(annotation.FruitColor());
            }
            if(declaredField.isAnnotationPresent(address.class)){
                address annotation = declaredField.getAnnotation(address.class);
                System.out.println(annotation.FruitAddress());
            }
        }
    }
    public static void main(String[] args) {
        get(Apple.class);
    }
}
