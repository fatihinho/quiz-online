package com.fcinar.quizonline.db.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "STUDENT_SCORE")
public class StudentScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
