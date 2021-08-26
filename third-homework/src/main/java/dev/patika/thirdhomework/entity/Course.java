package dev.patika.thirdhomework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Data // --> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode , @ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Builder
public class Course {

    //instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "credit_score")
    private double creditScore;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;






}
