package After;

import java.lang.annotation.*;

@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Color{
    public enum color{READ,BILU,RED}
    color FruitColor() default color.READ;
}
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface fruitName {
    String name() default "红富士";
}
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface address{
    String address() default "";
}
class Apple{
    @fruitName
    String name;
    String color;
    String addrss;
}
public class MyInnoation {
    public static void main(String[] args) {

    }
}
