package com.fcinar.quizonline.service;

import com.fcinar.quizonline.db.entity.Question;
import com.fcinar.quizonline.db.input.QuestionInput;
import com.fcinar.quizonline.db.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository repository;

    public Question getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Question> getAll() {
        return repository.findAll();
    }

    public Question create(QuestionInput input) {
        Question question = new Question();
        question.setQuestion(input.getQuestion());
        return repository.save(question);
    }

    public Question updateById(Long id, QuestionInput input) {
        Question question = getById(id);
        if (question != null) {
            question.setQuestion(input.getQuestion());
            return repository.save(question);
        } else {
            return null;
        }
    }

    public boolean deleteById(Long id) {
        Question question = getById(id);
        if (question != null) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAll() {
        repository.deleteAll();
        return true;

    }
}