package com.fcinar.quizonline.db.repository;

import com.fcinar.quizonline.db.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
