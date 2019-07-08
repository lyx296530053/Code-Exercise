package cn.lyx.se.everday.c3p0;

public class Emp {
    private Integer id;
    private String boyName;
    private  String userCP;

    public Emp(Integer id, String boyName, String userCP) {
        this.id = id;
        this.boyName = boyName;
        this.userCP = userCP;
    }

    public Emp() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoyName() {
        return boyName;
    }

    public void setBoyName(String boyName) {
        this.boyName = boyName;
    }

    public String getUserCP() {
        return userCP;
    }

    public void setUserCP(String userCP) {
        this.userCP = userCP;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", boyName='" + boyName + '\'' +
                ", userCP='" + userCP + '\'' +
                '}';
    }
}
