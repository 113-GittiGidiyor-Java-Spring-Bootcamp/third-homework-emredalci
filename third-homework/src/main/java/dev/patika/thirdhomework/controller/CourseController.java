package dev.patika.thirdhomework.controller;


import dev.patika.thirdhomework.entity.Course;
import dev.patika.thirdhomework.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Course>> findAllCourse(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id){
        return new ResponseEntity<>(courseService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/saveCourse")
    public Course saveCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course){
        return courseService.update(course);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
        return "Course deleted..";
    }

    @DeleteMapping("/deleteCourseByObject")
    public String deleteCourseByObject(@RequestBody Course course){
        courseService.delete(course);
        return "Course deleted..";
    }

    @DeleteMapping("/deleteCourseByName/{name}")
    public String deleteCourseByName(@PathVariable String name){
        courseService.deleteByName(name);
        return "Course deleted..";
    }


}
