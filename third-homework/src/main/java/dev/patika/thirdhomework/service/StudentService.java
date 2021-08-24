package dev.patika.thirdhomework.service;

import dev.patika.thirdhomework.entity.Student;
import dev.patika.thirdhomework.repository.StudentGenderStatistics;
import dev.patika.thirdhomework.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student>{

    private final StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        List<Student>  students = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        studentRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public List<StudentGenderStatistics> getGendersWithGrouping(){ // List<?> ???
        return studentRepository.getGendersWithGrouping();
    }
}
