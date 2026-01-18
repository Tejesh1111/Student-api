package com.example.Student_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Student_api.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
