package dev.patika.thirdhomework.repository;

import dev.patika.thirdhomework.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {

}
