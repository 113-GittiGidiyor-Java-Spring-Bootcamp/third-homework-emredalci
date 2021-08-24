package dev.patika.thirdhomework.service;

import dev.patika.thirdhomework.entity.Instructor;
import dev.patika.thirdhomework.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor>{

    private final InstructorRepository instructorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        List<Instructor> instructors = new ArrayList<>();
        Iterable<Instructor> instructorIterable = instructorRepository.findAll();
        instructorIterable.iterator().forEachRemaining(instructors::add);
        return instructors;
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(int id) {
        return instructorRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public Instructor update(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
}
