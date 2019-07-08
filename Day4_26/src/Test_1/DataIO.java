package Test_1;

import java.io.*;

public class DataIO {
    public static void main(String[] args) {
        DataOutputStream dot=null;
        try {
           dot=new DataOutputStream(new FileOutputStream("test.dat"));
           dot.writeUTF("黎燕翔");
           dot.flush();
           dot.writeInt(1996);
           dot.flush();
           dot.writeBoolean(false);
           dot.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(dot!=null){
                try {
                    dot.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        DataInputStream dis=null;
        try {
            dis=new DataInputStream(new FileInputStream("test.dat"));
            String str=dis.readUTF();
            Integer inte=dis.readInt();
            Boolean b=dis.readBoolean();
            System.out.println(str);
            System.out.println(inte);
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(dis!=null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
