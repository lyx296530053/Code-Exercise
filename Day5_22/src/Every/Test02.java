package Every;

public class Test02 {
    public static void main(String[] args) {
        String str = " 1d  v 217 ";

        int length = str.length();
        if (length == 0) {
            return;
        }
        int nowlength = 0;
        StringBuffer sb = null;
        StringBuffer real=null;
        int reallength = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if(nowlength==0){
                    nowlength++;
                    sb = new StringBuffer(String.valueOf(str.charAt(i)));
                } else {
                    nowlength++;
                    sb.append(str.charAt(i));
                    if (nowlength > reallength) {
                        reallength = nowlength;
                        real=sb;
                    }
                }
            } else{
            nowlength = 0;
            sb = null;
        }
    }
        System.out.println(real.toString());
}
}
