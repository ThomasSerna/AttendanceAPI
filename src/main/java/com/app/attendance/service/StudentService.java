package com.app.attendance.service;

import com.app.attendance.dto.StudentAttendanceDTO;
import com.app.attendance.entity.Course;
import com.app.attendance.entity.Student;
import com.app.attendance.repository.AttendanceRepository;
import com.app.attendance.repository.CourseRepository;
import com.app.attendance.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class StudentService {


    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final AttendanceRepository attendanceRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, AttendanceRepository attendanceRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.attendanceRepository = attendanceRepository;
    }

    @Transactional(readOnly = true)
    public StudentAttendanceDTO getStudentAttendances(String studentCode, String courseCode, Boolean attended){
        Student student = studentRepository.findByStudentCode(studentCode)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Student not found"));
        Course course = courseRepository.findByClassCode(courseCode)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Course not found"));

        return new StudentAttendanceDTO(
                student.getName(),
                student.getStudentCode(),
                course.getName(),
                course.getClassCode(),
                attendanceRepository.countByStudent_StudentCodeAndCourse_ClassCodeAndAssistedTrue(studentCode, courseCode, attended)
        );
    }


}
