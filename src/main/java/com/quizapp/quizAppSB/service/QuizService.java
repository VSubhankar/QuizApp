package com.quizapp.quizAppSB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.quizAppSB.model.*;
import com.quizapp.quizAppSB.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz modifyQuiz(Integer id, Quiz quiz) {
        if (quizRepository.existsById(id)) {
            quiz.setId(id);
            return quizRepository.save(quiz);
        }
        return null;
    }

    public void deleteQuiz(Integer id) {
        quizRepository.deleteById(id);
    }

    public Optional<Quiz> getQuiz(Integer id) {
        return quizRepository.findById(id);
    }

    public List<Quiz> listQuizzes() {
        return quizRepository.findAll();
    }
}
