package spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest_curd {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate(){
        //1 添加操作
//        // 第一步 编写sql语句
//        String sql = "insert into t_emp values(null,?,?,?)";
//        // 第二步 调用 jdbcTemplate 的方法，传入相关参数
//        Object[] params =  {"王五", 12, "女"};
//        int rows = jdbcTemplate.update(sql,params);
//        System.out.println(rows);

//        //2 修改操作
//        // 第一步 编写sql语句
//        String sql = "update t_emp set name = ? where id = ?";
//        // 第二步 调用 jdbcTemplate 的方法，传入相关参数
//        Object[] params =  {"王五666", 3};
//        int rows = jdbcTemplate.update(sql,params);
//        System.out.println(rows);

        //3 删除操作
        // 第一步 编写sql语句
        String sql = "delete from t_emp where id = ?";
        // 第二步 调用 jdbcTemplate 的方法，传入相关参数
        Object[] params =  {3};
        int rows = jdbcTemplate.update(sql,params);
        System.out.println(rows);

    }

}
