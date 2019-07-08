package Reflect;

import java.util.Date;

/**
 * Created by lyx on 2019/4/9.
 */

public class AnnotationCode {
    public  static void main(String[] args){
       test001();
    }
    @Deprecated
    public static void test001(){
        System.out.println("不建议使用");
    };
    @Override
    public String toString() {
        return "重写测试";
    }
    @MyAnnoation(age = 16,name = "lyx",id = 1001)
    public static void test002(){

    }
}
