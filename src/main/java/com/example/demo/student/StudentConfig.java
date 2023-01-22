package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Kind of Seed file for Students creation on boot
@Configuration
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      Student nischay = new Student(
        "Nischay",
        "nanud185@gmail.com",
        LocalDate.of(2006, Month.APRIL, 18)
      );

      Student nanu = new Student(
        "Nanu",
        "asdasd@gmail.com",
        LocalDate.of(1996, Month.APRIL, 18)
      );

      repository.saveAll(List.of(nischay, nanu));
    };
  }

}
