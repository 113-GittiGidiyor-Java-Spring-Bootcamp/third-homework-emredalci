package dev.patika.thirdhomework.service;

import dev.patika.thirdhomework.entity.Course;
import dev.patika.thirdhomework.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course>{

    private final CourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        Iterable<Course> courseIterable = courseRepository.findAll();
        courseIterable.iterator().forEachRemaining(courses::add);
        return courses;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        courseRepository.deleteByCourseName(name);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return courseRepository.save(course);
    }
}
