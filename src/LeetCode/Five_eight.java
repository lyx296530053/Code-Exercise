package LeetCode;

public class Five_eight {
    public static void main(String[] args) {
        String str = "Hello World nads    ";
        System.out.println(Five_eight.lengthOfLastWord(str));
    }

    public static int lengthOfLastWord(String s) {
        int length = s.length();
        while(s.charAt(length - 1) == ' '&&length>0){
            length--;
        }
        int i=length-1;
        for(;i>0;i--){
            if(s.charAt(i)==' '){
                break;
            }
        }
        return length-1-i;
    }
}
