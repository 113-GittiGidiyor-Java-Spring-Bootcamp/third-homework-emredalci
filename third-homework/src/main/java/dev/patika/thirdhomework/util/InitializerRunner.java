package dev.patika.thirdhomework.util;

import dev.patika.thirdhomework.entity.*;
import dev.patika.thirdhomework.repository.CourseRepository;
import dev.patika.thirdhomework.repository.InstructorRepository;
import dev.patika.thirdhomework.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

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

        //Instructor
        Instructor instructor1 = PermanentInstructor.builder().name("Koray Güney").address("İstanbul").phoneNumber("+9012345678901").fixedSalary(100).build();
        Instructor instructor2 = VisitingResearcher.builder().name("Ahmet Mehmet").address("Ankara").phoneNumber("+9012345678987").hourlySalary(50).build();

        //Course
        Course course1 = Course.builder().courseName("Bilgisayar Müh. Giriş").courseCode("CS101").creditScore(5).build();
        Course course2 = Course.builder().courseName("Algoritma Geliştirme").courseCode("Alg101").creditScore(5).build();

        //Student
        Student student1 = Student.builder().name("Cihan").birthDate(LocalDate.of(1990, Month.JANUARY,5)).address("Istanbul").gender('E').build();
        Student student2 = Student.builder().name("Ayse").birthDate(LocalDate.of(1996, Month.AUGUST,10)).address("Ankara").gender('K').build();
        Student student3 = Student.builder().name("Mehmet").birthDate(LocalDate.of(1995, Month.DECEMBER,20)).address("Bursa").gender('E').build();
        Student student4 = Student.builder().name("Fatma").birthDate(LocalDate.of(1994, Month.APRIL,14)).address("Izmir").gender('K').build();
        Student student5 = Student.builder().name("Gözde").birthDate(LocalDate.of(1993, Month.FEBRUARY,16)).address("Kocaeli").gender('K').build();
        Student student6 = Student.builder().name("Sibel").birthDate(LocalDate.of(1992, Month.MAY,17)).address("Antalya").gender('K').build();
        Student student7 = Student.builder().name("Pınar").birthDate(LocalDate.of(1991, Month.APRIL,2)).address("Tekirdağ").gender('K').build();

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        course1.getStudents().add(student3);
        course2.getStudents().add(student4);
        course2.getStudents().add(student5);
        course2.getStudents().add(student6);
        course2.getStudents().add(student7);


        //Save to Database
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        studentRepository.save(student7);

        courseRepository.save(course1);
        courseRepository.save(course2);

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);




    }
}
