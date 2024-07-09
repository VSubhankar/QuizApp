package com.example.quizApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quizApp.model.Question;

@Repository

public interface QuestionDao extends JpaRepository<Question, Integer>{
	
	@Query(value = "SELECT * FROM question q WHERE q.category = ?1", nativeQuery = true)
	List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
