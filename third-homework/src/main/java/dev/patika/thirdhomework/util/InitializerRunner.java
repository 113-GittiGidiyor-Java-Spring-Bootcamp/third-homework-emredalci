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
import java.util.ArrayList;
import java.util.List;

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
        Instructor instructor1 = PermanentInstructor.builder().name("Koray").address("İstanbul").phoneNumber("+9012345678901").fixedSalary(100).build();
        Instructor instructor2 = PermanentInstructor.builder().name("Ahmet").address("İstanbul").phoneNumber("+9012345678901").fixedSalary(200).build();
        Instructor instructor3 = PermanentInstructor.builder().name("Mehmet").address("İstanbul").phoneNumber("+9012345678901").fixedSalary(300).build();
        Instructor instructor4 = PermanentInstructor.builder().name("Emre").address("İstanbul").phoneNumber("+9012345678901").fixedSalary(400).build();



        Instructor instructor5 = VisitingResearcher.builder().name("Remzi").address("Ankara").phoneNumber("+9012345678987").hourlySalary(50).build();
        Instructor instructor6 = VisitingResearcher.builder().name("Erhan").address("Ankara").phoneNumber("+9012345678987").hourlySalary(75).build();
        Instructor instructor7 = VisitingResearcher.builder().name("Mustafa").address("Ankara").phoneNumber("+9012345678987").hourlySalary(80).build();
        Instructor instructor8 = VisitingResearcher.builder().name("Murat").address("Ankara").phoneNumber("+9012345678987").hourlySalary(90).build();

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


        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);

        course1.setStudents(students);
        /*
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        student1.setCourses(courses);
        */


        //Save to Database


        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        studentRepository.save(student7);

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);
        instructorRepository.save(instructor4);
        instructorRepository.save(instructor5);
        instructorRepository.save(instructor6);
        instructorRepository.save(instructor7);
        instructorRepository.save(instructor8);

        courseRepository.save(course1);
        courseRepository.save(course2);






    }
}
