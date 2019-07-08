interface Computer2{
    void printComputer();
}
class Lenovo2 implements Computer2{
    @Override
    public void printComputer() {
        System.out.println("这是联想电脑");
    }
}
class Mac implements Computer2{
    @Override
    public void printComputer() {
        System.out.println("这是苹果电脑");
    }
}
interface Systems{
    void printSystem();
}
class Win8System implements Systems{
    @Override
    public void printSystem() {
        System.out.println("这是win8系统");
    }
}
class IosSystem implements Systems{
    @Override
    public void printSystem() {
        System.out.println("这是Ios系统");
    }
}
interface  Factory2{
    Computer2 c();
    Systems s();
}
class LenovoFactory1 implements Factory2{
    @Override
    public Computer2 c() {
        return new Lenovo2();
    }
    @Override
    public Systems s() {
        return new Win8System();
    }
}
class MacFactory1 implements Factory2{
    @Override
    public Computer2 c() {
        return new Mac();
    }
    @Override
    public Systems s() {
        return new IosSystem();
    }
}
class  cilent{
    public void buyComputer(Computer2 computer2){
        computer2.printComputer();
    }
    public void system(Systems systems){
        systems.printSystem();
    }
}
public class AbstructFactory {
    public static void main(String[] args) {
    Factory2 factory2=new LenovoFactory1();
    cilent cilent=new cilent();
    cilent.buyComputer(factory2.c());
    cilent.system(factory2.s());
    }
}
