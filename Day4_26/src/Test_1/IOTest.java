package Test_1;

import java.io.*;

public class IOTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ObjectOutputStream oos=null;
        try {
            oos=new ObjectOutputStream(new FileOutputStream("test.dat"));
            oos.writeObject(new String("abc"));
            oos.flush();
            oos.writeObject(new Integer(567));
            oos.flush();
            oos.writeObject(new Person("lyx",123));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(new FileInputStream("test.dat"));
            String str=(String) ois.readObject();
            Integer inte=(Integer)ois.readObject();
            Person p=(Person)ois.readObject();
            System.out.println(str);
            System.out.println(inte);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
