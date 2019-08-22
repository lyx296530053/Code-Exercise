package cn.lyx;

    import java.util.*;

public class Main {

    public  static void test(int temp,int i,String str){
      if(i==str.length()){
          if(temp==1){
              System.out.println('N');
              return;
          }else if(temp==2){
              System.out.println('S');
              return;
          }else if(temp==3){
              System.out.println('W');
              return;
          }else System.out.println('E');
          return;
      }
        if(temp==1){
            if(str.charAt(i)=='L'){
                temp=3;
                test(temp,++i,str);
            }else {
                temp =4;
                test(temp,++i,str);
            }
        }
        if(temp==4){
            if(str.charAt(i)=='L'){
                temp=1;
                test(temp,++i,str);
            }else {
                temp =2;
                test(temp,++i,str);
            }
        }
        if(temp==2){
            if(str.charAt(i)=='L'){
                temp=4;
                test(temp,++i,str);
            }else {
                temp =3;
                test(temp,++i,str);
            }
        }
        if(temp==3){
            if(str.charAt(i)=='L'){
                temp=2;
                test(temp,++i,str);
            }else {
                temp =1;
                test(temp,++i,str);
            }
        }
    }
    public void test2(int a,int b,int temp){
        if(a>temp||b>temp){
            return;
        }

        test2(a,b,temp);
        
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        String string = scanner.next();
        test(1,0,string);
    }
}
