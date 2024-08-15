package com.quizapp.quizAppSB.controller;

import com.quizapp.quizAppSB.service.*;
import com.quizapp.quizAppSB.model.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/quiz-list")
public class QuizListController {

    @Autowired
    private QuizListService quizListService;

    // Get all quiz IDs
    @GetMapping
    public ResponseEntity<List<QuizList>> listQuizzes() {
        List<QuizList> questions = quizListService.getAllQuizzes();
        return ResponseEntity.ok(questions);
    }
}

