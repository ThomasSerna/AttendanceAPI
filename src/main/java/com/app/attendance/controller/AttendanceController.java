package com.app.attendance.controller;

import com.app.attendance.dto.ApiResponse;
import com.app.attendance.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllAttendances(){
        return ResponseEntity.ok(new ApiResponse<>(
                "Data retrieved successfully",
                attendanceService.getAllAttendances()
        ));
    }

    @GetMapping(value = "/{courseCode}", params = "date")
    public ResponseEntity<ApiResponse<Object>> getAttendancesByNameAndDate(@PathVariable String courseCode, @RequestParam LocalDate date){
        return ResponseEntity.ok(new ApiResponse<>(
                "Data retrieved successfully",
                attendanceService.getAttendancesByClassCodeAndDate(date, courseCode)
        ));
    }

}
