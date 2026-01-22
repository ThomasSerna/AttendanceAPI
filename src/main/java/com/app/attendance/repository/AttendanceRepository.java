package com.app.attendance.repository;

import com.app.attendance.entity.Attendance;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Override
    @NullMarked
    @EntityGraph(attributePaths = {"student", "course"}) // o solo {"student"}
    List<Attendance> findAll();

    @EntityGraph(attributePaths = {"student", "course"})
    List<Attendance> findAllByClassDateAndCourse_ClassCode(LocalDate classDate, String courseClassCode);

    @EntityGraph(attributePaths = {"student", "course"})
    List<Attendance> findAllByCourse_ClassCode(String courseClassCode);

    Long countByStudent_StudentCodeAndCourse_ClassCodeAndAssistedTrue(String studentStudentCode, String courseClassCode, Boolean assisted);
}
