package com.lessons.pojo;

public class Student {

    private int id;
    private String professional;
    private String userName;
    private String password;
    private String trueName;
    private String stuNo;


    public Student() {
    }

    public Student(int id, String professional, String userName, String password, String trueName, String stuNo, String stuNo1) {
        this.id = id;
        this.professional = professional;
        this.userName = userName;
        this.password = password;
        this.trueName = trueName;
        this.stuNo = stuNo;
        this.stuNo = stuNo1;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", trueName='" + trueName + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", professional='" + professional + '\'' +
                '}';
    }


}
