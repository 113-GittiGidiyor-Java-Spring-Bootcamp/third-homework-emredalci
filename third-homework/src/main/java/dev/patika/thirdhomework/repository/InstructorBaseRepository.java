package dev.patika.thirdhomework.repository;

import dev.patika.thirdhomework.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface InstructorBaseRepository<T extends Instructor> extends CrudRepository<T,Integer> {

    void deleteByName(String instructorName);

}
