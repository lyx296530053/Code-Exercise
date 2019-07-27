package cn.lyx.annotation;

import org.junit.Test;

import java.lang.annotation.*;
import java.lang.reflect.Field;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Name {
    enum computerName {LENOVO, DEll, MAC}

    computerName name() default computerName.LENOVO;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Color {
    enum computerColor {BLACK, RED, WHITE}

    computerColor color() default computerColor.BLACK;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Provide {
    String name() default "";

    String address() default "";
}

public class MyAnnotation {
    public void getComputerAnnoation(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Name.class)) {
                Name name = field.getAnnotation(Name.class);
                System.out.println("电脑名称：" + name.name());
            } else if (field.isAnnotationPresent(Color.class)) {
                Color color = field.getAnnotation(Color.class);
                System.out.println("电脑颜色：" + color.color());
            } else if (field.isAnnotationPresent(Provide.class)) {
                Provide annotation = field.getAnnotation(Provide.class);
                System.out.println("供应商名称：" + annotation.name() + "\n" + "供应商地址：" + annotation.address());
            }
        }
    }

    class Computer {
        @Name(name = Name.computerName.LENOVO)
        String name;
        @Color(color = Color.computerColor.RED)
        String color;
        @Provide(name = "富士康", address = "中国台湾省台北市")
        String provide;
    }

    @Test
    public void test() {
        getComputerAnnoation(Computer.class);
    }
}


