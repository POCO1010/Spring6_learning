package spring6.tx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import spring6.tx.controller.BookController;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestBookTx{
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        Integer[] bookIds = {1,2};
        bookController.checkoutBook(bookIds,1);
    }
}
