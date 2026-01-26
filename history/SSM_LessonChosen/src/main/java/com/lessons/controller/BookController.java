package com.lessons.controller;

import com.lessons.pojo.Book;
import com.lessons.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Resource
    BookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }

}
