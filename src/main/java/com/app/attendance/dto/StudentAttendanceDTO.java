package com.app.attendance.dto;

public class StudentAttendanceDTO {

    private String studentName;
    private String studentCode;
    private String courseName;
    private String courseCode;
    private Long courseAttendance;

    public StudentAttendanceDTO(String studentName, String studentCode, String courseName, String courseCode, Long courseAttendance) {
        this.studentName = studentName;
        this.studentCode = studentCode;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseAttendance = courseAttendance;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getCourseAttendance() {
        return courseAttendance;
    }

    public void setCourseAttendance(Long courseAttendance) {
        this.courseAttendance = courseAttendance;
    }
}
