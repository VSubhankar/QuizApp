package com.quizapp.quizAppSB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.quizAppSB.model.QuizList;
import com.quizapp.quizAppSB.repository.QuizListRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuizListService {

    @Autowired
    private QuizListRepository quizListRepository;

    // Method to get all quiz IDs and titles
    public List<QuizList> getAllQuizzes() {
        return quizListRepository.findAll();
    }

    // Method to get a quiz by its ID
    public Optional<QuizList> getQuizById(Integer quizId) {
        return quizListRepository.findById(quizId);
    }

    // Method to add a new quiz to the list
    public QuizList addQuiz(QuizList quizList) {
        return quizListRepository.save(quizList);
    }

    // Method to delete a quiz by its ID
    public void deleteQuiz(Integer quizId) {
        quizListRepository.deleteById(quizId);
    }

    // Method to get the total number of quizzes
    public long getTotalQuizzes() {
        return quizListRepository.count();
    }
}

