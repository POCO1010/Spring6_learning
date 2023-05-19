package spring6.xmltx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring6.xmltx.service.BookService;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;



    public void buyBook(Integer bookId ,Integer userId){
        //调用Service方法
        bookService.buyBook(bookId,userId);
    }

}
