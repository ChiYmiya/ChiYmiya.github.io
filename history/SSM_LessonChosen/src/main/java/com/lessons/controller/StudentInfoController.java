package com.lessons.controller;

import com.lessons.pojo.Student;
import com.lessons.pojo.StudentCourse;
import com.lessons.service.StudentService;
import com.lessons.util.R;
import com.lessons.util.code;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/studentinfo")
public class StudentInfoController {
    @Resource
    private StudentService studentService;

    // 学生课表查询 根据学生的id来查学生个人信息
    @GetMapping
    public R getStudentCourse(@RequestParam Integer id){


        Student studentInfo = studentService.getStudentinfo(id);

        return new R(studentInfo, code.GET_OK,"查询个人信息成功！");

    }

    /***
     * 修改修生信息  接受的对象 封装Student
     * @param student
     * @return
     */
    @PutMapping
    public R updateStudentCourse(@RequestBody Student student){



        boolean studentInfo = studentService.updateStudentinfo(student);

        return new R(studentInfo, code.GET_OK,"修改个人信息成功！");

    }
}
