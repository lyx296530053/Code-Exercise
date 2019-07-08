package cn.lyx.se.everday.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class JDBCTemplate {
    public static void main(String[] args) throws SQLException {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(Utiles.getDataSources());
//        String s="update log set passward=? where id=?";
        String s="select count(id) from log";
//        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(s);
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(s);
//        for (Map<String, Object> map : maps) {
//           for (String s1 : map.keySet()) {
//               System.out.print(map.get(s1)+" ");
//           }
//            System.out.println(map);
//       }
//        List<Emp> query = jdbcTemplate.query(s, new BeanPropertyRowMapper<Emp>(Emp.class));
//        for (Emp emp : query) {
//            System.out.println(emp);
        Long aLong = jdbcTemplate.queryForObject(s, Long.class);
        System.out.println(aLong);
    }
    }
