package com.app.attendance.repository;

import com.app.attendance.entity.Attendance;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @EntityGraph(attributePaths = {"student", "course"})
    List<Attendance> findAllByClassDateAndCourse_Name(LocalDate classDate, String courseName);
}
