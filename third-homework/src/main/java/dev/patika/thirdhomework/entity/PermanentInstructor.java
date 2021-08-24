package dev.patika.thirdhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Data // --> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode , @ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PermanentInstructor extends Instructor{

    //instance variables
    @Column(name = "fixed_salary")
    private double fixedSalary;

}
