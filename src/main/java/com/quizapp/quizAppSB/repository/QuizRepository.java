package com.quizapp.quizAppSB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.quizapp.quizAppSB.model.*;

import java.util.List;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, Integer> {

    // Find quizzes by title
    List<Quiz> findByTitle(String title);

    // Find quizzes by a question ID (for example, if needed)
    List<Quiz> findByQuestionsId(Integer questionId);
}
