package After;

class Person {
    private static final Person PERSON = new Person();

    private Person() {
    }

    ;

    public static Person getPerson() {
        return PERSON;
    }
}
class Person1{
    private static Person1 person1=null;
    private Person1(){};
    public static Person1 getPerson1(){
        if(person1==null){
            person1=new Person1();
        }
        return person1;
    }
}
class Person2{
    private static Person2 person1=null;
    private Person2(){};
    public static Person2 getPerson1(){
        if(person1==null){
            synchronized (Person2.class) {
                if(person1==null) {
                    person1 = new Person2();
                }
            }
        }
        return person1;
    }
}
class Person3{
    private Person3(){};
    private static class get{
        private static final Person3 p=new Person3();
    }
    public static Person3 getPerson3(){
        return get.p;
    }
}
public class Signal {
    public static void main(String[] args) {

    }
}
