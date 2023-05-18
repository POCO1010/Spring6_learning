package spring6.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring6.tx.dao.BookDao;

@Transactional
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;


    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //根据图书id查询价格
        Integer price =  bookDao.getBookPriceByBookId(bookId);
        //更新图书表库存量 -1
        bookDao.updateStock(bookId);
        //更新用户表用户余额 -图书价格
        bookDao.updateUserBalance(userId,price);
    }
}
