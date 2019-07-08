package Reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

interface Isubject{
    void eat();
}
class RealSubject implements Isubject{

    @Override
    public void eat() {
        System.out.println("吃饺子！！！");
    }
}
class ProxySubject implements Isubject{
    private Isubject isb;

    public ProxySubject(Isubject isb) {
        this.isb = isb;
    }
    void prev(){
        System.out.println("开始做饭！！！");
    }
    void next(){
        System.out.println("收拾餐具！！！");
    }
    @Override
    public void eat() {
    this.prev();
    this.isb.eat();
    this.next();
    }
}
class  Factory {
    public Factory() {
    }

    public static <T> T getInstance(String name) {
        T t = null;
        try {
            try {
                t = (T) Class.forName(name).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T getInstance(String name, Object o) {
        T t = null;
        try {
            try {
                Constructor constructor = Class.forName(name).getConstructor(o.getClass().getInterfaces()[0]);
                try {
                    t = (T) constructor.newInstance(o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
}
public class ProxyMode {
    public static void main(String[] args) {
    Isubject isubject=Factory.getInstance("Reflact.ProxySubject",Factory.getInstance("Reflact.RealSubject"));
    isubject.eat();
    }
}
