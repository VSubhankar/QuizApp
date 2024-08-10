package com.quizapp.quizAppSB.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "questionList")
public class QuestionList {

    @Id
    private Integer questionId;
    private String title;

    // Constructors, getters, and setters are automatically handled by Lombok
}
