package com.app.attendance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class RequestDTO {

    @NotNull
    private LocalDate date;

    @NotBlank
    private String courseName;

    @NotBlank
    private String courseCode;

    @NotEmpty
    private List<RecordDTO> assistance;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<RecordDTO> getAssistance() {
        return assistance;
    }

    public void setAssistance(List<RecordDTO> assistance) {
        this.assistance = assistance;
    }
}
