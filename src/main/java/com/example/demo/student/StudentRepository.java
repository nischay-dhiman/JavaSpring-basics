package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// We want this StudentRepository to work on "Student" type

@Repository // Responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> {

  Optional<Student> findStudentByEmail(String email);
}
