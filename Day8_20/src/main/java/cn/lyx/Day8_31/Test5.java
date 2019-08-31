package cn.lyx.Day8_31;



import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String a = scanner.nextLine();
        String b=scanner.nextLine();
        Object[] objects = Arrays.stream(a.split(" ")).map(o->{
            Character[] c=new Character[b.length()];
            for (int i = 0; i < b.length(); i++) {
                c[i]=b.charAt(i);
            }
            List<String> collect = Arrays.stream(c).map(String::valueOf).collect(Collectors.toList());
            collect.toArray();
            for (int i = 0; i <collect.size(); i++) {
                if(o.contains(collect.get(i))){
                    String s = collect.get(i);
                    char[] chars = s.toCharArray();
                    StringBuilder sb=new StringBuilder();
                    for (int j = 0; j < o.length(); j++) {
                        if(o.charAt(j)!=chars[0]){
                            sb.append(o.charAt(j));
                        }
                    }
                    o=sb.toString();
                }
            }
            return o;
        }).toArray();
        for (int i = 0; i <objects.length ; i++) {
            if(i==objects.length-1) {
                System.out.print(objects[i]);
            }else
                System.out.print(objects[i]+" ");
        }
    }
}
