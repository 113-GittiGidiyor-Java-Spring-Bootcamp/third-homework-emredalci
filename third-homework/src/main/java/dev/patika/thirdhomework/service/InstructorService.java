package dev.patika.thirdhomework.service;

import dev.patika.thirdhomework.entity.Instructor;
import dev.patika.thirdhomework.repository.InstructorRepository;
import dev.patika.thirdhomework.repository.PermanentInstructorRepository;
import dev.patika.thirdhomework.repository.VisitingResearcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor>{

    private final InstructorRepository instructorRepository;
    private final PermanentInstructorRepository permanentInstructorRepository;
    private final VisitingResearcherRepository visitingResearcherRepository;

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
    @Transactional
    public void deleteByName(String name) {
        instructorRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public void delete(Instructor instructor) {
        instructorRepository.delete(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Transactional
    public List<Instructor> top3ByOrderByFixedSalaryDesc() {
        return permanentInstructorRepository.findTop3ByOrderByFixedSalaryDesc();
    }

    @Transactional
    public List<Instructor> top3ByOrderByFixedSalaryAsc() {
        return permanentInstructorRepository.findTop3ByOrderByFixedSalaryAsc();
    }

    @Transactional
    public List<Instructor> top3ByOrdeOrderByHourlySalaryAsc(){
        return visitingResearcherRepository.findTop3ByOrdeOrderByHourlySalaryAsc();
    }

    @Transactional
    public List<Instructor> top3ByOrdeOrderByHourlySalaryDesc(){
        return visitingResearcherRepository.findTop3ByOrdeOrderByHourlySalaryDesc();
    }


}
