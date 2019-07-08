package cn.lyx.web.xml.JDBC;

import java.util.Scanner;

public class LogIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        boolean login = new Denglu().login(username, password);
        if (login == true) {
            System.out.println("登陆成功");
        } else {
            System.out.println("密码错误");
        }
    }
}
