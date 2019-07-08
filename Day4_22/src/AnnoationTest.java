class Peoplew{
    public void show(){
        System.out.println("renzoulu");
    }
}
class Personw extends Peoplew{
    @Override
    public void show(){
        System.out.println("走了吗");
    }
}
@interface MyAnnoation{
    String value();
}
public class AnnoationTest {
    public static void main(String[] args) {
        Peoplew personw=new Peoplew();
        personw.show();
    }
}
