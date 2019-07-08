package StringTest;

public class SpiltTest {
    public static void main(String[] args) {
        String name="hello word hello byte";
        //String split = name.split(" ")[0];
        //System.out.println(name.substring(0,1).toUpperCase());
        //System.out.println(name.substring(1));
        //System.out.println(split);
        String[] split = name.split(" ",3);
        for (String s:split
             ) {
            System.out.println(s);
        }
    }
}
