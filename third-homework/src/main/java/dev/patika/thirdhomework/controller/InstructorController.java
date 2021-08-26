package dev.patika.thirdhomework.controller;


import dev.patika.thirdhomework.entity.Instructor;
import dev.patika.thirdhomework.repository.InstructorRepository;
import dev.patika.thirdhomework.repository.PermanentInstructorRepository;
import dev.patika.thirdhomework.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/instructor")
public class InstructorController {


    private final InstructorService instructorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Instructor>> findAllInstructor(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id){
        return new ResponseEntity<>(instructorService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/saveInstructor")
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }

    @PutMapping("/updateInstructor")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }

    @DeleteMapping("/deleteInstructor/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
        return "Instructor deleted..";
    }

    @DeleteMapping("/deleteInstructorByObject")
    public String deleteInstructorByObject(@RequestBody Instructor instructor){
        instructorService.delete(instructor);
        return "Instructor deleted..";
    }

    @DeleteMapping("/deleteInstructorByName/{name}")
    public String deleteInstructorByName(@PathVariable String name){
        instructorService.deleteByName(name);
        return "Instructor deleted..";
    }

    @GetMapping("/top3ByOrderByFixedSalaryDesc")
    public List<Instructor> top3ByOrderByFixedSalaryDesc(){
        return instructorService.top3ByOrderByFixedSalaryDesc();
    }

    @GetMapping("/top3ByOrderByFixedSalaryAsc")
    public List<Instructor> top3ByOrderByFixedSalaryAsc(){
        return instructorService.top3ByOrderByFixedSalaryAsc();
    }

    @GetMapping("/top3ByOrderByHourlySalaryAsc")
    public List<Instructor> top3ByOrderByHourlySalaryAsc(){
        return instructorService.top3ByOrderByHourlySalaryAsc();
    }

    @GetMapping("/top3ByOrderByHourlySalaryDesc")
    public  List<Instructor> top3ByOrderByHourlySalaryDesc(){
        return  instructorService.top3ByOrderByHourlySalaryDesc();
    }



}
