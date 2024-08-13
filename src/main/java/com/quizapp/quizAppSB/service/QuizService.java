package com.quizapp.quizAppSB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.quizAppSB.model.NewQuiz;
import com.quizapp.quizAppSB.model.Question;
import com.quizapp.quizAppSB.model.Quiz;
import com.quizapp.quizAppSB.model.QuizList;
import com.quizapp.quizAppSB.repository.QuestionRepository;
import com.quizapp.quizAppSB.repository.QuizListRepository;
import com.quizapp.quizAppSB.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizListRepository quizListRepository;

    @Autowired
    private QuestionRepository questionRepository;

    // Add a new quiz
    public Quiz addQuiz(NewQuiz newQuiz) {
        int id = Math.toIntExact(quizRepository.count()) + 1;
        String title = newQuiz.getTitle();
        List<Question> questions = new ArrayList<>();

        for (int questionId : newQuiz.getQuestions()) {
            Optional<Question> question = questionRepository.findById(questionId);
            if (question.isPresent()) {
                questions.add(question.get());
            } else {
                throw new RuntimeException("Question with ID " + questionId + " not found.");
            }
        }

        QuizList quizList = new QuizList();
        quizList.setQuizId(id);
        quizList.setTitle(title);
        quizListRepository.save(quizList);

        Quiz quiz = new Quiz();
        quiz.setId(id);
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        return quizRepository.save(quiz);
    }

    // Modify an existing quiz by omitting specific questions
    public Quiz modifyQuiz(Integer quizId, List<Integer> omitQuestionIds) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (!optionalQuiz.isPresent()) {
            throw new RuntimeException("Quiz with ID " + quizId + " not found.");
        }

        Quiz quiz = optionalQuiz.get();

        List<Question> filteredQuestions = quiz.getQuestions().stream()
                .filter(question -> !omitQuestionIds.contains(question.getId()))
                .collect(Collectors.toList());

        quiz.setQuestions(filteredQuestions);

        return quizRepository.save(quiz);
    }

    // Delete a quiz by ID and also remove it from QuizList
    public void deleteQuiz(Integer id) {
        quizRepository.deleteById(id);
        quizListRepository.deleteById(id);
    }

    // Get a quiz by ID
    public Optional<Quiz> getQuiz(Integer id) {
        return quizRepository.findById(id);
    }

    // List all quizzes
    public List<Quiz> listQuizzes() {
        return quizRepository.findAll();
    }
}
