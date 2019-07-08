package FaceObject;

interface Caculater {
    setoOld SETO_OLD();

    int result();

    void set(setoOld setoOld);

    void setFirst(int a);

    void setSecond(int b);
}

class Real implements Caculater {
    private int first;
    private int second;

    public Real(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public Real() {

    }

    @Override
    public setoOld SETO_OLD() {
        return new CangKu(first, second);
    }

    @Override
    public void set(setoOld setoOld) {
        this.first = ((getOld) setoOld).getFirst();
        this.second = ((getOld) setoOld).getSecond();
    }

    @Override
    public void setFirst(int first) {
        this.first = first;
    }

    @Override
    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public int result() {
        return this.second + this.first;
    }
}

interface setoOld {
}

interface getOld {
    int getFirst();

    int getSecond();
}

class CangKu implements setoOld, getOld {
    private int first;
    private int second;

    public CangKu(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int getFirst() {
        return this.first;
    }

    @Override
    public int getSecond() {
        return this.second;
    }
}

public class Jisuanqi {
    public static void main(String[] args) {
        Caculater caculater = new Real();
        caculater.setFirst(8);
        caculater.setSecond(7);
        System.out.println(caculater.result());
        setoOld setoOld = caculater.SETO_OLD();
        caculater.setFirst(15);
        caculater.setSecond(15);
        System.out.println(caculater.result());
        caculater.set(setoOld);
        System.out.println(caculater.result());
    }
}
