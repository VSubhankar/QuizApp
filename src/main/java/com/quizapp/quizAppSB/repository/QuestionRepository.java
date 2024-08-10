package com.quizapp.quizAppSB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.quizapp.quizAppSB.model.*;
import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question, Integer> {

    // Find questions by text
    List<Question> findByQuestionText(String questionText);


    // Find questions by an option (if needed)
    List<Question> findByOptionsContaining(String option);
}
