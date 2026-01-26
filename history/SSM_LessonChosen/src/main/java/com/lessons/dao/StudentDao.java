package com.lessons.dao;

import com.lessons.pojo.Course;
import com.lessons.pojo.Student;
import com.lessons.pojo.StudentCourse;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDao {
    @Select("SELECT t2.id as studentId ,t2.userName as studentName, t4.id as id,t3.id as courseId,t3.courseName AS courseName,t3.credit AS credit,t1.trueName AS teacherName,t4.score AS score FROM t_teacher t1,t_student t2,t_course t3,t_student_course t4 WHERE t2.id=t4.studentId AND t3.id=t4.courseId AND t3.teacherId=t1.id AND t2.id=#{id}")
    List<StudentCourse> getStudentCourse(@Param("id") Integer id);

    @Select("select * from t_student where id=#{id}")
    Student getStudentInfo(@Param("id")Integer id);
    @Update("update t_student set userName=#{userName},password=#{password},trueName=#{trueName},stuNo=#{stuNo},professional=#{professional} where id=#{id}")
    boolean updateStudentinfo(Student student);

    @Select("SELECT t4.id as id,t3.id as courseId,t3.courseName AS courseName,t3.credit AS credit,t1.trueName AS teacherName,t4.score AS score FROM t_teacher t1,t_student t2,t_course t3,t_student_course t4 WHERE t2.id=t4.studentId AND t3.id=t4.courseId AND t3.teacherId=t1.id AND t2.id=#{id}")
    List<StudentCourse> getStudentCourseLeaning(Integer id);


    @Insert("insert into t_student_course values(null,#{studentId},#{courseId},null)")
    boolean addStudentCourseLeaning(Course course);


    @Delete("delete from t_student_course where id=#{id}")
    boolean delStudentCourseLeaning(int id);

    @Select("select * from t_course where  id not in(select courseId from t_student_course where studentId=#{id})")
    List<StudentCourse> Studentlesson(Integer id);
}
