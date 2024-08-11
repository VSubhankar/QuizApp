package com.quizapp.quizAppSB.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quizapp.quizAppSB.service.*;
import com.quizapp.quizAppSB.model.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Add a new quiz
    @PostMapping
    public ResponseEntity<Quiz> addQuiz(@RequestBody NewQuiz quiz) {
        Quiz savedQuiz = quizService.addQuiz(quiz);
        return ResponseEntity.ok(savedQuiz);
    }

    // Modify an existing quiz
    @PutMapping("/{id}")
    public ResponseEntity<Quiz> modifyQuiz(@PathVariable Integer id, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.modifyQuiz(id, quiz);
        if (updatedQuiz != null) {
            return ResponseEntity.ok(updatedQuiz);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a quiz
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Integer id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }

    // Get a quiz by ID
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Integer id) {
        Optional<Quiz> quiz = quizService.getQuiz(id);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // List all quizzes
    @GetMapping
    public ResponseEntity<List<Quiz>> listQuizzes() {
        List<Quiz> quizzes = quizService.listQuizzes();
        return ResponseEntity.ok(quizzes);
    }
}
