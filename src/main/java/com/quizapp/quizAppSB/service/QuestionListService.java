package com.quizapp.quizAppSB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.quizAppSB.model.QuestionList;
import com.quizapp.quizAppSB.repository.QuestionListRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionListService {

    @Autowired
    private QuestionListRepository questionListRepository;

    // Method to get all question IDs and titles
    public List<QuestionList> getAllQuestions() {
        return questionListRepository.findAll();
    }

    // Method to get a question by its ID
    public Optional<QuestionList> getQuestionById(Integer questionId) {
        return questionListRepository.findById(questionId);
    }

    // Method to add a new question to the list
    public QuestionList addQuestion(QuestionList questionList) {
        return questionListRepository.save(questionList);
    }

    // Method to delete a question by its ID
    public void deleteQuestion(Integer questionId) {
        questionListRepository.deleteById(questionId);
    }

    // Method to get the total number of questions
    public long getTotalQuestions() {
        return questionListRepository.count();
    }
}

