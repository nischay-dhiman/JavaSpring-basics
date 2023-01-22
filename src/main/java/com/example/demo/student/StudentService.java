package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class StudentService{
  
	private StudentRepository studentRepository;

	@Autowired
  public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		// this.createStudents();
		return studentRepository.findAll();
	}

	public String createStudent(Student new_student) {
		// check if student already exist with same email

		Optional<Student> studentEmail = studentRepository.findStudentByEmail(new_student.getEmail());

		if(studentEmail.isPresent()){
			// throw exception here
			throw new IllegalStateException("Email already taken"); 
		}
		studentRepository.save(new_student);
		return "Student Created Succesfully";
	}

	public void deleteStudent(Long studentId) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		
		// Also could use existsById
		// Boolean studentExists = studentRepository.existsById(studentId);

		if(studentOptional.isEmpty()){
			// throw exception here
			throw new IllegalStateException("Student doesn't exist"); 
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional // Dont have to write sql, and use setters from Student
  public void updateStudent(Long studentId, Student studentDetails) {
		Boolean studentExists = studentRepository.existsById(studentId);
		if(!studentExists){
			throw new IllegalStateException("Student doesn't exist");
		}
		// Update using setters manually
		Student student = studentRepository.findById(studentId)
			.orElseThrow(() -> new IllegalStateException("Student Not Found"));
		student.setName(studentDetails.getName());
  }

}
