package com.app.attendance.service;

import com.app.attendance.dto.RecordDTO;
import com.app.attendance.dto.RequestDTO;
import com.app.attendance.entity.Attendance;
import com.app.attendance.entity.Course;
import com.app.attendance.entity.Student;
import com.app.attendance.repository.AttendanceRepository;
import com.app.attendance.repository.CourseRepository;
import com.app.attendance.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Transactional
    public void saveAttendance(RequestDTO requestDTO) {
        for (RecordDTO record : requestDTO.getAssistance()) {

        }
    }

    @Transactional
    public Student getStudentByName(String studentName){
        return studentRepository.findByName(studentName)
                .orElse(studentRepository.save(new Student(studentName)));
    }

    @Transactional
    public Course getCourseByName(String courseName){
        return courseRepository.findByName(courseName)
                .orElse(courseRepository.save(new Course(courseName)));
    }
}
