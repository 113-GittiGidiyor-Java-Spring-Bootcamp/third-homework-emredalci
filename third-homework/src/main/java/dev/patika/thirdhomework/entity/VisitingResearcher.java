package dev.patika.thirdhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Data // --> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode , @ToString
@NoArgsConstructor
@AllArgsConstructor
public class VisitingResearcher extends Instructor{

    //instance variables
    @Column(name = "hourly_salary")
    private double hourlySalary;
}