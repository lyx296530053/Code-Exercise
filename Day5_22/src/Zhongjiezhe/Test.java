package Zhongjiezhe;

abstract class Collection {
    abstract void onEven(Modiator modiator);
}
class Alarm extends Collection{

    @Override
    void onEven(Modiator modiator) {
        modiator.doEvent("alarm");
    }
    public void doAlarm(){
        System.out.println("闹钟工作");
    }
}
class Coffee extends Collection{

    @Override
    void onEven(Modiator modiator) {
        modiator.doEvent("coffee");
    }
    public void doCoffee(){
        System.out.println("Coffee工作");
    }
}
class Calendar extends Collection{

    @Override
    void onEven(Modiator modiator) {
        modiator.doEvent("calender");
    }
    public void doCalender(){
        System.out.println("日历工作");
    }
}
abstract class Modiator {
    abstract void doEvent(String s);
}
class concreatModiator extends Modiator{
    private Alarm alarm;
    private Coffee coffeePot;
    private Calendar calender;

    public concreatModiator(Alarm alarm, Coffee coffeePot, Calendar calender) {
        this.alarm = alarm;
        this.coffeePot = coffeePot;
        this.calender = calender;
    }

    @Override
    void doEvent(String s) {
        switch (s) {
            case "alarm":
                doAlarmEvent();
                break;
            case "coffee":
                doCoffeePotEvent();
                break;
            case "calender":
                doCalenderEvent();
                break;
            default:
              return;
        }
    }

    private void doCalenderEvent() {
        calender.doCalender();
    }

    private void doCoffeePotEvent() {
        coffeePot.doCoffee();
        calender.doCalender();
    }

    private void doAlarmEvent() {
        alarm.doAlarm();
        coffeePot.doCoffee();
        calender.doCalender();
    }
}
public class Test {
    public static void main(String[] args) {
    Modiator modiator=new concreatModiator(new Alarm(),new Coffee(),new Calendar());
    new Alarm().onEven(modiator);
    new Coffee().onEven(modiator);
    }
}
