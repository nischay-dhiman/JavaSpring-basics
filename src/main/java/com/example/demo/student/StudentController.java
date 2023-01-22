package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/students/")
public class StudentController {
  
  private final StudentService studentService;

  // autowired mages studentService to be automatically instantiated
  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/empty")
  public List<Student> getList(){
    return List.of(
      new Student()
    );
  }

  @GetMapping("/")
	public List<Student> students() {
		return this.studentService.getStudents();
	}

  @PostMapping(value="/", consumes = {"application/json"})
	public String createStudent(@RequestBody Student student) {
    return this.studentService.createStudent(student);
	}

  @DeleteMapping("{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long studentId){
    this.studentService.deleteStudent(studentId);
  }

  @PutMapping(value="{studentId}", consumes = {"application/json"})
  public void updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student studentDetails){
    this.studentService.updateStudent(studentId, studentDetails);
  }
}
