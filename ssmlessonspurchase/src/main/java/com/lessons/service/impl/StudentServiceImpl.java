package com.lessons.service.impl;

import com.lessons.dao.StudentDao;
import com.lessons.pojo.Course;
import com.lessons.pojo.Student;
import com.lessons.pojo.StudentCourse;
import com.lessons.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {


    @Resource
    StudentDao studentDao;
    @Override
    public List<StudentCourse> getStudentCourse(Integer id) {
        return studentDao.getStudentCourse(id);
    }

    @Override
    public Student getStudentinfo(Integer id) {
        return studentDao.getStudentInfo(id);
    }

    @Override
    public boolean updateStudentinfo(Student student) {
        return studentDao.updateStudentinfo(student);
    }

    @Override
    public List<StudentCourse> getStudentCourseLeaning(Integer id) {

        return studentDao.getStudentCourseLeaning(id);
    }

    @Override
    public boolean addStudentCourseLeaning(Integer id, int[] arr) {

        for (int i = 0; i <arr.length; i++) {
            studentDao.addStudentCourseLeaning(new Course(id,arr[i]));
        }
        return true;
    }


    @Override
    public boolean delStudentCourseLeaning(int[] arr) {

        for (int i = 0; i <arr.length ; i++) {
            studentDao.delStudentCourseLeaning(arr[i]);
        }
        return true;
    }

    @Override
    public List<StudentCourse> Studentlesson(Integer id) {
        return  studentDao.Studentlesson(id);
    }
}
