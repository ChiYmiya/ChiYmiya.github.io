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
@RequestMapping("/studentlessonController")
public class StudentlessonController {

    /***
     * 查询未选课的课程
     */

    @Resource
    private StudentService studentService;

    @GetMapping
    private R getStudentCourseLeaning(@RequestParam Integer id){

        List<StudentCourse> studentCourses=studentService.Studentlesson(id);
        return new  R(studentCourses, code.GET_OK,"查询成功！");
    }

}
