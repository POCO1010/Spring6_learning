package spring6.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring6.tx.service.BookService;
import spring6.tx.service.CheckoutService;

@Controller
public class BookController {

//    @Autowired
//    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;


//    public void buyBook(Integer bookId ,Integer userId){
//        //调用Service方法
//        checkoutService.buyBook(bookId,userId);
//    }
    public void checkoutBook(Integer[] bookIds,Integer userId){
        checkoutService.checkout(bookIds,userId);
    }
}
