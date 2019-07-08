package cn.lyx.web.xml.JDBC;

public class Emp {
    Integer id;
    String name;
    Integer usercap;

    public Emp(Integer id, String name, Integer usercap) {
        this.id = id;
        this.name = name;
        this.usercap = usercap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUsercap() {
        return usercap;
    }

    public void setUsercap(Integer usercap) {
        this.usercap = usercap;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", usercap=" + usercap +
                '}';
    }
}
