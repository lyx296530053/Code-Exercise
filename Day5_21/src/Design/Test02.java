package Design;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitName {
    String value() default "";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitColor {
  enum color {RED, BLACK, BLUE}
    color FruitColor() default color.RED;

}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface dress {
    public String name() default "";

    public int age() default -1;

    public String address() default "";

}

class Util {
    public static void getInnoation(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(FruitName.class)) {
                FruitName annotation = declaredField.getAnnotation(FruitName.class);
                System.out.println(annotation.value());
            }
            if (declaredField.isAnnotationPresent(FruitColor.class)) {
                FruitColor annotation = declaredField.getAnnotation(FruitColor.class);
                System.out.println(annotation.FruitColor());
            }
            if (declaredField.isAnnotationPresent(dress.class)) {
                dress annotation = declaredField.getAnnotation(dress.class);
                System.out.println(annotation.name() + annotation.age() + annotation.address());
            }
        }
    }
}

class Apple {
    @FruitName("红富士")
    private String name;
    @FruitColor(FruitColor = FruitColor.color.BLACK)
    private String color;
    @dress(name = "lyx", age = 18, address = "陕西省西安市长安区")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
public class Test02 {
    public static void main(String[] args) {
        Util.getInnoation(Apple.class);
    }
}
