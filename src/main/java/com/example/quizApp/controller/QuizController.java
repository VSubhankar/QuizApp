package com.example.quizApp.controller;

import com.example.quizApp.model.QuestionWrapper;
import com.example.quizApp.model.Response;
import com.example.quizApp.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// controller for quiz
@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
    	return quizService.createQuiz(category, numQ, title);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
    	System.out.println("Received responses:");
        for (Response response : responses) {
            System.out.println("Response ID: " + response.getId());
            System.out.println("Response Value: " + response.getResponse());
        }
    	return quizService.calculateResult(id, responses);
    }
}
