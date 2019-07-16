package cn.lyx.stack;

public class StackByArray implements StackTest {
    private String[] strings;
    private int count;
    private int n;

    public StackByArray(int n) {
        this.strings = new String[n];
        this.count = 0;
        this.n = n;
    }

    @Override
    public boolean push(String o) {
        if (count >= n) {
            return false;
        } else {
            strings[count] = o;
            count++;
            return true;
        }
    }

    @Override
    public Object pop() {
        if (strings == null) {
            return null;
        }
        String string = strings[count - 1];
        count--;
        return string;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public Object isEmpty() {
        return strings.length == 0;
    }

    @Override
    public int getSize() {
        return count;
    }

    public static void main(String[] args) {
        StackByArray stackByArray=new StackByArray(4);
        stackByArray.push("1");
        stackByArray.push("2");
        stackByArray.push("3");
        stackByArray.push("4");
        System.out.println(stackByArray.pop());
    }
}
