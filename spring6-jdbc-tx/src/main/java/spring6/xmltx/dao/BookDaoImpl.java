package spring6.xmltx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据图书id查询价格
     * @param bookId
     * @return price
     */
    @Override
    public Integer getBookPriceByBookId(Integer bookId) {
        String sql = "select price from spring.t_book where book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;
    }

    /**
     * 更新库存
     * @param bookId
     */
    @Override
    public void updateStock(Integer bookId) {
        String sql = "update spring.t_book set stock = stock -1 where book_id =?";
        jdbcTemplate.update(sql, bookId);
    }

    /**
     * 更新用户余额
     * @param userId
     * @param price
     */
    @Override
    public void updateUserBalance(Integer userId, Integer price) {
        String sql = "update spring.t_user set balance = balance - ? where user_id = ?";
        jdbcTemplate.update(sql,price,userId);
    }
}
