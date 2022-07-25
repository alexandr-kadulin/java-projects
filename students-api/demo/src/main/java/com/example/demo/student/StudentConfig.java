package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student john = new Student(
                    "John",
                    LocalDate.of(2000, Month.APRIL, 5),
                    "john@gmail.com"
            );

            Student pam = new Student(
                    "Pam",
                    LocalDate.of(2005, Month.AUGUST, 15),
                    "pam@gmail.com"
            );

            repository.saveAll(
                    List.of(john, pam)
            );
        };
    }
}
