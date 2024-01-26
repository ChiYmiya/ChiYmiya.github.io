package com.lessons.controller;


import com.lessons.pojo.StudentCourse;
import com.lessons.service.StudentService;
import com.lessons.util.R;
import com.lessons.util.code;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    // 学生课表查询 根据学生的id来查学生的课程表
    @GetMapping
    public R getStudentCourse(@RequestParam Integer id){


        List<StudentCourse> studentCourse = studentService.getStudentCourse(id);

        return new R(studentCourse, code.GET_OK,"查询课表成功！");

    }


}
