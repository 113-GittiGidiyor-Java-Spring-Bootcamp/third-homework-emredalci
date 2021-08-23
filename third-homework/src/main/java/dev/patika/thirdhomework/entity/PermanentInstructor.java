package dev.patika.thirdhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Data // --> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode , @ToString
@AllArgsConstructor
@NoArgsConstructor
public class PermanentInstructor extends Instructor{

    //instance variables
    @Column(name = "fixed_salary")
    private double fixedSalary;

}