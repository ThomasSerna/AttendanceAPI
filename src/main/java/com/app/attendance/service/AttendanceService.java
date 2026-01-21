package com.app.attendance.service;

import com.app.attendance.repository.AttendanceRepository;
import com.app.attendance.repository.CourseRepository;
import com.app.attendance.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }
}
