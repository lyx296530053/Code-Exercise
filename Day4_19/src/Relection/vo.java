/**
* 1,截取字符串得到set属性和需要赋值
 * 2，
 *
*
* */
package Relection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Emp {
    private String ename ;
    private String job ;
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public java.lang.String toString() {
        return "Emp{" +
                "ename=" + ename +
                ", job=" + job +
                '}';
    }
}
class EmpSet{
     private Emp emp=new Emp();
     public void setValue(String value) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
         BeanOperation.getBean(this,value);
     }

    public Emp getEmp() {
        return emp;
    }
}
class BeanOperation{
     public static void getBean(Object obj,String msg) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
         String[] split = msg.split("\\|");
         for(int i=0;i<split.length;i++){
             String[] split1 = split[i].split(":");
             String oan=split1[0];
             String value=split1[1];
             String[] split2 = oan.split("\\.");
             String pre = split2[1].substring(0, 1).toUpperCase();
             String aft = split2[1].substring(1);
             StringBuilder sb=new StringBuilder("get");
             sb.append(pre);
             sb.append(aft);
             Field field=obj.getClass().getDeclaredField(split2[1]);
             if(field==null){
                 field=obj.getClass().getField(split2[1]);
             }
             if(field==null){return ;}
             Method method=obj.getClass().getDeclaredMethod(sb.toString(),field.getType());
             Object invoke = method.invoke(obj);
             StringBuilder sb1=new StringBuilder("set");
             sb1.append(pre);
             sb1.append(aft);
             Method method1=invoke.getClass().getDeclaredMethod(sb1.toString(),field.getType());
             method1.invoke(invoke,value);
         }
     }

}
public class vo {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
       String value="emp.ename:lyx|emp.job:java code";
       EmpSet empSet=new EmpSet();
       empSet.setValue(value);
       System.out.println(empSet.getEmp());
    }
}
