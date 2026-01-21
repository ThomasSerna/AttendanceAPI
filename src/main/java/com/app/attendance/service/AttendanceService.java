package com.app.attendance.service;

import com.app.attendance.dto.RecordDTO;
import com.app.attendance.dto.RequestDTO;
import com.app.attendance.entity.Attendance;
import com.app.attendance.entity.Course;
import com.app.attendance.entity.Student;
import com.app.attendance.repository.AttendanceRepository;
import com.app.attendance.repository.CourseRepository;
import com.app.attendance.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    private static final Logger log = LoggerFactory.getLogger(AttendanceService.class);

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
        log.info("Class: {} - Date: {}", requestDTO.getCourseName(), requestDTO.getDate());
        for (RecordDTO record : requestDTO.getAssistance()) {
            attendanceRepository.save(new Attendance(
                    getStudentByName(record.getStudentName()),
                    getCourseByName(requestDTO.getCourseName(), requestDTO.getCourseCode()),
                    record.getAttended(),
                    requestDTO.getDate()
                    ));
            log.info("Student: {} - Assisted: {}", record.getStudentName(), record.getAttended());
        }
    }

    @Transactional(readOnly = true)
    public List<Attendance> getAttendancesByClassCodeAndDate(LocalDate classDate, String classCode){
        return attendanceRepository.findAllByClassDateAndCourse_ClassCode(classDate, classCode);
    }

    @Transactional(readOnly = true)
    public List<Attendance> getAllAttendances(){
        return attendanceRepository.findAll();
    }

    public Student getStudentByName(String studentName){
        return studentRepository.findByName(studentName)
                .orElse(studentRepository.save(new Student(studentName)));
    }

    public Course getCourseByName(String courseName, String courseCode){
        return courseRepository.findByName(courseName)
                .orElse(courseRepository.save(new Course(courseName, courseCode)));
    }
}
