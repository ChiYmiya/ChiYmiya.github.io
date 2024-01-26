package com.lessons.service.impl;

import com.lessons.dao.BookDao;
import com.lessons.pojo.Book;
import com.lessons.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
