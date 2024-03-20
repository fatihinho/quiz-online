package com.fcinar.quizonline.db.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "QUIZ")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    private List<Question> questions;
}
