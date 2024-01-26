package com.lessons.controller;

import com.lessons.pojo.Course;
import com.lessons.pojo.StudentCourse;
import com.lessons.service.StudentService;
import com.lessons.util.R;
import com.lessons.util.code;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/studentlessonchoiceController")
public class StudentlessonchoiceController {

    @Resource
    private StudentService studentService;


    /***
     * 已选课程
     * @param id 学生id 根据学生id查询已选课程
     * @return
     */
    @GetMapping
    private R getStudentCourseLeaning(@RequestParam Integer id){

       List<StudentCourse> studentCourses=studentService.getStudentCourseLeaning(id);
        return new  R(studentCourses, code.GET_OK,"查询成功！");
    }

    /***
     * 根据课程课程名称来添加选中课程
      * @param
     *
     * @return
     */
    @PostMapping
    private R addStudentCourseLeaning( @RequestParam("stuId") Integer prams, @RequestBody int[]  arr ){

        System.out.println(Arrays.toString(arr));
        System.out.println(prams);
        boolean b = studentService.addStudentCourseLeaning(prams,arr);


        return new R(code.SAVE_OK,"添加成功");

    }
    @DeleteMapping
    private R delStudentCourseLeaning(@RequestBody int[]  arr){

        System.out.println(Arrays.toString(arr));
//        System.out.println(course);
        boolean b = studentService.delStudentCourseLeaning(arr);


        return new R(code.DELETE_OK,"删除成功");

    }


}
