package Every;

public class Test01 {
    public static void main(String[] args) {
        for (int i=0;i<=100;i++) {
            System.out.println(i+"    "+show(i));
        }
    }
    public static int show(int n){
        if (n%2!=0||n<6){
            return -1;
        }
        if(n%8==0&&n/8!=0){
            return n/8;
        }
        for (int y=n/8; y>=0 ; y--) {
            for(int x=n/6;x>=0;x--){
                if(6*x+8*y==n){
                   return x+y;
                }
            }
        }
        return -1;
    }
}
