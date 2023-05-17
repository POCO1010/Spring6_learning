package spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    // 自定义类的全量查询（where）
    @Test
    public void testSelect(){
        String sql = "select * from spring.t_emp where id = ?";
        Emp empResult = jdbcTemplate.queryForObject(sql,
              new BeanPropertyRowMapper<>(Emp.class)
//            (rs, rowNum) -> {
//                Emp emp = new Emp();
//                emp.setId(rs.getInt("id"));
//                emp.setName(rs.getString("name"));
//                emp.setAge(rs.getInt("age"));
//                emp.setSex(rs.getString("sex"));
//                return emp;
//            }
        ,1);
        System.out.println(empResult);

    }


    //自定义类的全量查询
    @Test
    public void testSelectList(){
        String sql = "select * from spring.t_emp";
        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        for (Emp emp : query) {
            System.out.println(emp);
        }
    }

    //单值查询
    @Test
    public void testSelectNum(){
        String sql = "select count(1) from spring.t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }


}
