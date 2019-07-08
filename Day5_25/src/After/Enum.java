package After;
enum Enum {
    ENUM;
    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Enum e=Enum.ENUM;
    }
}
