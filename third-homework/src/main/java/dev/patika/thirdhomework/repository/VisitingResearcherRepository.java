package dev.patika.thirdhomework.repository;

import dev.patika.thirdhomework.entity.Instructor;
import dev.patika.thirdhomework.entity.VisitingResearcher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitingResearcherRepository extends InstructorBaseRepository<VisitingResearcher>{

    List<Instructor> findTop3ByOrderByHourlySalaryAsc();
    List<Instructor> findTop3ByOrderByHourlySalaryDesc();

}
