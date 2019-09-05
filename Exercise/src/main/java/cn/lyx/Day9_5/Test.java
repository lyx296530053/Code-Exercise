package cn.lyx.Day9_5;

public class Test {
   static String  string = "a";
    static String temp = "b";

    public static void main(String[] args) {
        Test test = new Test();
        test.swap(test.string);
        System.out.println(test.string + temp);
    }

    public void swap(String str) {
        str +="c";
        temp = str;
    }
}