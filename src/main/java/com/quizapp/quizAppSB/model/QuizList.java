package com.quizapp.quizAppSB.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "quizList")
public class QuizList {

    @Id
    private Integer quizId;
    private String title;

    // Constructors, getters, and setters are automatically handled by Lombok
}

