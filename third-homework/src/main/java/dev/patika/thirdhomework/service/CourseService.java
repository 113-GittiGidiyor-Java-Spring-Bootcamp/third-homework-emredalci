package dev.patika.thirdhomework.service;

import dev.patika.thirdhomework.entity.Course;
import dev.patika.thirdhomework.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course>{

    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {

        return null;
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course save(Course object) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public Course update(Course object) {
        return null;
    }
}
