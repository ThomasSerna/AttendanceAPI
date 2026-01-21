package com.app.attendance.dto;

import jakarta.validation.constraints.NotNull;

public class RecordDTO {

    @NotNull
    private String studentName;

    @NotNull
    private Boolean attended;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Boolean getAttended() {
        return attended;
    }

    public void setAttended(Boolean attended) {
        this.attended = attended;
    }
}
