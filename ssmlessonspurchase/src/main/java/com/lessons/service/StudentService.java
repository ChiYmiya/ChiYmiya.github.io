package com.lessons.service;

import com.lessons.pojo.Course;
import com.lessons.pojo.Student;
import com.lessons.pojo.StudentCourse;

import java.util.List;

public interface StudentService {
    List<StudentCourse> getStudentCourse(Integer id);

    Student getStudentinfo(Integer id);

    boolean updateStudentinfo(Student student);

    List<StudentCourse> getStudentCourseLeaning(Integer id);

    boolean addStudentCourseLeaning(Integer id ,int[] arr);

    boolean delStudentCourseLeaning(int[] arr);

    List<StudentCourse> Studentlesson(Integer id);
}
