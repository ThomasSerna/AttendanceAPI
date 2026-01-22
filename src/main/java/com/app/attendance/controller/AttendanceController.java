package com.app.attendance.controller;

import com.app.attendance.dto.ApiResponse;
import com.app.attendance.dto.RequestDTO;
import com.app.attendance.service.AttendanceService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
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

    @GetMapping(value = "/{courseCode}")
    public ResponseEntity<ApiResponse<Object>> getAttendancesByCode(@PathVariable String courseCode){
        return ResponseEntity.ok(new ApiResponse<>(
                "Data retrieved successfully",
                attendanceService.getAttendancesByCode(courseCode)
        ));
    }

    @GetMapping(value = "/{courseCode}", params = "date")
    public ResponseEntity<ApiResponse<Object>> getAttendancesByCodeAndDate(@PathVariable String courseCode, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return ResponseEntity.ok(new ApiResponse<>(
                "Data retrieved successfully",
                attendanceService.getAttendancesByClassCodeAndDate(date, courseCode)
        ));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> createAttendance(@Valid @RequestBody RequestDTO requestDTO){
        attendanceService.saveAttendance(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(
                "Data saved successfully",
                null
        ));
    }

}
