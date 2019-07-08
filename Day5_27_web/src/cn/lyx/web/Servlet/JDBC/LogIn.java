package cn.lyx.web.Servlet.JDBC;

public class LogIn {
   static public String username = null;
    static public String password = null;
    public boolean log() {

        boolean login = new Denglu().login(username, password);
       return login;
    }
}
