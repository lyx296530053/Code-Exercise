package cn.lyx.se.everday.c3p0;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        DataSource dataSources = Utiles.getDataSources();
        JdbcTemplate template=new JdbcTemplate(dataSources);
        String str="select * from boys";
        List<Emp> query = template.query(str, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : query) {
            System.out.println(emp);
        }
        List<Map<String, Object>> maps = template.queryForList(str);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
}
