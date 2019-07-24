package cn.lyx.Class;

import org.junit.Test;

public class Test1 {
    @Test
    public void test() throws ClassNotFoundException {
        MyClassLoader myClassLoader=new MyClassLoader("C:\\Users\\DELL\\IdeaProjects\\Code-Exercise\\Day7_23\\target\\classes\\cn\\lyx\\Collection");
        myClassLoader.findClass("ListTest");
    }
}
