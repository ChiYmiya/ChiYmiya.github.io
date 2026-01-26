package com.lessons.pojo;

public class Course {
    private Integer studentId;
    private Integer courseId;

    @Override
    public String toString() {
        return "Course{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Course() {
    }

    public Course(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}
