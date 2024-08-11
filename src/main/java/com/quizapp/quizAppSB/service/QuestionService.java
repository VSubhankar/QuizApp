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

    @Autowired
    private QuestionListRepository questionListRepository;

    public Question addQuestion(NewQuestion question) {
        int id = Math.toIntExact(questionRepository.count())+1;
        String text = question.getQuestionText();
        List<String> options = question.getOptions();
        String answer = question.getCorrectAnswer();
        QuestionList ql = new QuestionList();
        ql.setQuestionId(id);
        ql.setTitle(text);
        questionListRepository.save(ql);
        Question q = new Question();
        q.setQuestionText(text);
        q.setId(id);
        q.setOptions(options);
        q.setCorrectAnswer(answer);
        return questionRepository.save(q);
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

