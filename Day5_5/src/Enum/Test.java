package Enum;

enum Season{
    SPRING("春天","春暖花开"),
    SUMMER("夏天","烈日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","寒风刺骨");
        private final String name;
        private final String type;
    Season(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
public class Test {
    public static void main(String[] args) {
        Season season = Season.AUTUMN;
        System.out.println(season);
        Season sensor1 = Season.valueOf("winter".toUpperCase());
        System.out.println(sensor1);
        Season[] season1=Season.values();
        for (Season season2 : season1) {
            System.out.println(season2);
        }
    }
}
