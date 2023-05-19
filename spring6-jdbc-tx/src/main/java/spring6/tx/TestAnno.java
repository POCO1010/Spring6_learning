package spring6.tx;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring6.tx.config.SpringConfig;
import spring6.tx.controller.BookController;

public class TestAnno {
    @Test
    public void testTxAllAnnotation(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController =
                applicationContext.getBean("bookController", BookController.class);
        Integer[] bookIds = {1,2};
        bookController.checkoutBook(bookIds,1);
    }
}
