package Reflect;
import BaseClass.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lyx on 2019/4/2.
 */
public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, NoSuchFieldException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        Class cls=Class.forName("BaseClass.Test");
        Test tt=(Test) cls.newInstance();//获取当前类的对象



        //1.Field类中常用方法
        //获取类中的属性(共有 自己加父类)
        Field bfiled=cls.getField("a");
        //获取类中全部属性
        Field[] fields=cls.getFields();
        //获取类中属性(共有加私有 自己类)
        Field pri=cls.getDeclaredField("b") ;
        //获取类中全部属性（公有加私有 自己类）
        Field[] pris=cls.getDeclaredFields();
        /* int=getModifiers() 获取属性修饰符（权限加特性）
         * Class=getType() 获取属性类型对应的那个Class
         * String= getName() 获取属性名字
         * 操作属性
         * set(对象，值);给属性赋值
         * Object=get(对象)从某个对象内取得属性的值
         * 如果是私有的不能直接操作
         * setAccessable(true);设置一个使用权
         
         */
        //2.Class中常用的方法
        //获取类(权限，特征)修饰符
        int modifiers=cls.getModifiers();
        System.out.println(modifiers);
        //类的名字
        String name=cls.getName();
        String simpleName=cls.getSimpleName();
        System.out.println(name+" "+simpleName);
        //获取类所在的包
        Package p= cls.getPackage();//返回值Package
        System.out.println(p.getName());
        //获取当前class父类
        Class clss=cls.getSuperclass();
        System.out.println(clss.getName());
        //获取当前类父亲接口
        Class[] clazz=cls.getInterfaces();
        //获取类中的内部类(public)
        Class[] in=cls.getClasses();

        //3.获取类中方法
    Class clsss=Test.class;
    Method m=clsss.getMethod("add",int.class);//可以获得自己加父类的公有方法
         Method[] ms=clsss.getMethods();//获取所有自己和父类公有的方法
        Method mp=clsss.getDeclaredMethod("add",int.class);//获取自己类方法私有加公有
        Method[] mps=cls.getDeclaredMethods();//获取自己类全部方法私有加公有
        mp.setAccessible(true);//设置方法使用权
    int a=(int)m.invoke(tt,2);
    int mm=m.getModifiers();//获取方法修饰符（权限加特性）
    Class mrt=m.getReturnType();//获取方法返回值类型
    String mn=m.getName();//获取方法名称
    Class[] mpts=m.getParameterTypes();//获取方法参数列表类型
    Class[] mets=m.getExceptionTypes();//获取方法抛出异常的类型




    //4.获取类中构造方法
        Constructor con=cls.getConstructor(int.class,String.class);
        Test t1=(Test)con.newInstance(2,"qwe");//执行一次创建对象返回值Object对象
        System.out.println(t1);
        Constructor[] cons =cls.getDeclaredConstructors();
        con.setAccessible(true);
        Constructor conp=cls.getDeclaredConstructor(int.class,String.class);
        Constructor[] conps=cls.getDeclaredConstructors();





    }
}
