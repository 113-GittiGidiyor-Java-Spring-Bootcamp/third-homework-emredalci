package dev.patika.thirdhomework.repository;

import dev.patika.thirdhomework.entity.Instructor;
import dev.patika.thirdhomework.entity.PermanentInstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {

    void deleteByName(String instructorName);

    List<Instructor> findFirst3ByNameOrderBySalaryDesc();

    List<Instructor> findFirst3ByNameOrderBySalaryAsc();

}
