package InnerClass;


class People{
    private String name;
    public Integer age;
    class Person01{
        String name;
        Integer age;
        public void show(){
            System.out.println("i;m inner");
        }
    }
    public static class person{
         String name;
        Integer age;
        public void show(){
            System.out.println("i;m inner");
        }
    }
    public void fun(){
        person person=new person();
        person.show();
    }
    public void show(int test){
        class Inner{
            public void show(){
                System.out.println(test);
            }
        }
        new Inner().show();
    }
}
public class Test {
    public static void main(String[] args) {
        People.person p=new People.person();
        p.show();
        new People().fun();

        People.Person01 p1=new People().new Person01();
        p1.show();
        new People().show(20);
    }
}
