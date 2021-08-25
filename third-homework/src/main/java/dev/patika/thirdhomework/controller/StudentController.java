package dev.patika.thirdhomework.controller;

import dev.patika.thirdhomework.entity.Student;
import dev.patika.thirdhomework.repository.StudentGenderStatistics;
import dev.patika.thirdhomework.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/fimdAll")
    public ResponseEntity<List<Student>> findAllStudent(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id){
        return new ResponseEntity<>(studentService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student){
        return  studentService.update(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteById(id);
        return "Student deleted..";
    }

    @DeleteMapping("deleteStudentByObject")
    public String deleteStudentByObject(@RequestBody Student student){
        studentService.delete(student);
        return "Student deleted..";
    }

    @GetMapping("/genderWithGrouping")
    public ResponseEntity<List<StudentGenderStatistics>> getGendersWithGrouping(){
        return (ResponseEntity<List<StudentGenderStatistics>>) studentService.getGendersWithGrouping();
    }

    @DeleteMapping("/deleteStudentByName/{name}")
    public String deleteStudentByName(@PathVariable String name){
        studentService.deleteByName(name);
        return "Student deleted..";
    }








}
