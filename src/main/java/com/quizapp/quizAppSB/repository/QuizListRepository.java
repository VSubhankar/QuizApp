package com.quizapp.quizAppSB.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.quizapp.quizAppSB.model.*;

@Repository
public interface QuizListRepository extends MongoRepository<QuizList, Integer> {
}
