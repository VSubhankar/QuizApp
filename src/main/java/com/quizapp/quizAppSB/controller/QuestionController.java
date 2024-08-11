package com.quizapp.quizAppSB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quizapp.quizAppSB.model.*;
import com.quizapp.quizAppSB.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Add a new question
    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody NewQuestion question) {
        Question savedQuestion = questionService.addQuestion(question);
        return ResponseEntity.ok(savedQuestion);
    }

    // Modify an existing question
    @PutMapping("/{id}")
    public ResponseEntity<Question> modifyQuestion(@PathVariable Integer id, @RequestBody Question question) {
        Question updatedQuestion = questionService.modifyQuestion(id, question);
        if (updatedQuestion != null) {
            return ResponseEntity.ok(updatedQuestion);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a question
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    // Get a question by ID
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Integer id) {
        Optional<Question> question = questionService.getQuestion(id);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // List all questions
    @GetMapping
    public ResponseEntity<List<Question>> listQuestions() {
        List<Question> questions = questionService.listQuestions();
        return ResponseEntity.ok(questions);
    }
}
