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

    @Autowired
    private QuizListRepository quizListRepository;

    public Quiz addQuiz(NewQuiz newQuiz) {
        int id = Math.toIntExact(quizRepository.count()) + 1;
        String title = newQuiz.getTitle();
        List<Question> questions = newQuiz.getQuestions();

        // Save to QuizList
        QuizList quizList = new QuizList();
        quizList.setQuizId(id);
        quizList.setTitle(title);
        quizListRepository.save(quizList);

        // Create and save Quiz
        Quiz quiz = new Quiz();
        quiz.setId(id);
        quiz.setTitle(title);
        quiz.setQuestions(questions);
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
