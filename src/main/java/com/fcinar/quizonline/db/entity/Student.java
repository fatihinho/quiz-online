package com.fcinar.quizonline.db.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
