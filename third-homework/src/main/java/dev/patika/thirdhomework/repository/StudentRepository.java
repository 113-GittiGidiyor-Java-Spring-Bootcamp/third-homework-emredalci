package dev.patika.thirdhomework.repository;

import dev.patika.thirdhomework.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    void deleteByName(String studentName);

    @Query("select s.gender, count(s.gender) from Student s GROUP BY s.gender")
    List<?> getGendersWithGrouping();

}
