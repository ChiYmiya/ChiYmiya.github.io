package com.lessons.dao;

import com.lessons.pojo.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface BookDao {
    @Select("select * from tbl_book")
    public List<Book> getAll();
}
