package cn.lyx.fenzhi;

public class HannoTower {
    public static void main(String[] args) {
        move(3, 'a', 'b', 'c');
    }

    public static void move(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("从"+a+"----》"+c);
        } else {
            move(n - 1, a, c, b);
            System.out.println("从"+a+"----》"+c);
            move(n - 1, b, a, c);
        }
    }
}
