package com.lessons.dao;

import com.lessons.pojo.Student;

import com.lessons.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
    public interface LoginDao {
    @Select("SELECT * FROM t_student WHERE username=#{username}")
    User getUserByName(@Param("username") String username);
    @Select("SELECT id from t_student WHERE username=#{username}")
    Integer getIdByName(@Param("username") String username);
}

