package dev.patika.thirdhomework.repository;


import dev.patika.thirdhomework.entity.Instructor;
import dev.patika.thirdhomework.entity.PermanentInstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermanentInstructorRepository extends InstructorBaseRepository<PermanentInstructor>{

    List<Instructor> findTop3ByOrderByFixedSalaryDesc();

    List<Instructor> findTop3ByOrderByFixedSalaryAsc();

}
