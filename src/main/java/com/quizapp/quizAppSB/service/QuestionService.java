package com.quizapp.quizAppSB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quizapp.quizAppSB.model.*;
import com.quizapp.quizAppSB.repository.*;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question modifyQuestion(Integer id, Question question) {
        if (questionRepository.existsById(id)) {
            question.setId(id);
            return questionRepository.save(question);
        }
        return null;
    }

    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }

    public Optional<Question> getQuestion(Integer id) {
        return questionRepository.findById(id);
    }

    public List<Question> listQuestions() {
        return questionRepository.findAll();
    }
}

