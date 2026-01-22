package com.app.attendance.controller;

import com.app.attendance.dto.ApiResponse;
import com.app.attendance.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/{courseCode}/{studentCode}", params = "attended")
    public ResponseEntity<ApiResponse<Object>> getStudentAttendances(@PathVariable String courseCode, @PathVariable String studentCode, @RequestParam Boolean attended){
        return ResponseEntity.ok(new ApiResponse<>(
                "Data retrieved successfully",
                studentService.getStudentAttendances(studentCode, courseCode, attended)
        ));
    }
}
