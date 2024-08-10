package com.quizapp.quizAppSB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quizapp.quizAppSB.service.*;
import com.quizapp.quizAppSB.model.*;
import java.util.List;

@RestController
@RequestMapping("/question-lists")
public class QuestionListController {

    @Autowired
    private QuestionListService questionListService;

    // Get all question IDs
    @GetMapping("/ids")
    public ResponseEntity<List<QuestionList>> getAllQuestions() {
        List<QuestionList> questions = questionListService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }
}
