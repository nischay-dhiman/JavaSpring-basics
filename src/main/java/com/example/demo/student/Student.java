package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity // Hibernate
@Table  // Table in our DB
public class Student {
  
  // Next three annotations are realted to DB connectivity
  @Id

  @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1
  )

  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_sequence"
  )


  private Long id;
  private String name;
  private String email;
  private LocalDate dob;

  @Transient // means it doesnot need to be in db, it could be calculated
  private Integer age;

  public Student() {
  }


  public Student( Long id,
                  String name,
                  String email,
                  LocalDate dob) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.dob = dob;
  }

  public Student(  String name,
                String email,
                LocalDate dob) {
      this.name = name;
      this.email = email;
      this.dob = dob;
  }

  


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDob() {
    return this.dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public Integer getAge() {
    return Period.between(this.dob, LocalDate.now()).getYears();
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", email='" + getEmail() + "'" +
      ", dob='" + getDob() + "'" +
      ", age='" + getAge() + "'" +
      "}";
  }
  
}
