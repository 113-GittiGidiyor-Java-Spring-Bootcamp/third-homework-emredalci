package dev.patika.thirdhomework.util;

import dev.patika.thirdhomework.entity.Course;
import dev.patika.thirdhomework.repository.CourseRepository;
import dev.patika.thirdhomework.repository.InstructorRepository;
import dev.patika.thirdhomework.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializerRunner implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        // Delete database
        courseRepository.deleteAll();
        instructorRepository.deleteAll();
        studentRepository.deleteAll();

        //Course
        

    }
}
