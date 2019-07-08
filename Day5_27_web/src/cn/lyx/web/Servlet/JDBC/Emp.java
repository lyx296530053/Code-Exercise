package cn.lyx.web.Servlet.JDBC;

public class Emp {
    Integer id;
    String name;
    Integer password;

    public Emp(Integer id, String name, Integer usercap) {
        this.id = id;
        this.name = name;
        this.password = usercap;
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

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}
