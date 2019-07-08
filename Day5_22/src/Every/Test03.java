package Every;

public class Test03 {
    public static void main(String[] args) {

    }

    public boolean chkParenthesis(String A, int n) {
        int y = 0;
        int x = 0;
        if (n % 2 == 0) {
            int length = A.length();
            for (int i = 0; i < length; i++) {
                if (A.charAt(i) == ')' || A.charAt(i) == '(') {
                    x++;
                    if (A.charAt(i) == ')') {
                        y++;
                    }
                }
            }
            if (x % y == 0) {
                return true;
            } else{
                return false;
            }
        } else {
            return false;
        }
    }
}
