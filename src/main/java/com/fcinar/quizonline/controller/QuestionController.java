package com.fcinar.quizonline.controller;

import com.fcinar.quizonline.db.entity.Question;
import com.fcinar.quizonline.db.input.QuestionInput;
import com.fcinar.quizonline.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/quizzes")
public class QuestionController {

    private final QuestionService service;

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getById(@PathVariable("id") Long id) {
        Question question = service.getById(id);
        if (question != null) {
            return ResponseEntity.status(HttpStatus.OK).body(question);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/question")
    public ResponseEntity<List<Question>> getAll() {
        List<Question> questionList = service.getAll();
        if (!questionList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(questionList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/question/create")
    public ResponseEntity<Question> create(@RequestBody QuestionInput input) {
        Question entity = service.create(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("/question/{id}/update")
    public ResponseEntity<Question> updateById(@PathVariable("id") Long id, @RequestBody QuestionInput input) {
        Question entity = service.updateById(id, input);
        if (entity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/question/{id}/delete")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        boolean isDeleted = service.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}