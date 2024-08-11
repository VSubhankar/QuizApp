package com.quizapp.quizAppSB.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.List;

@Data
@Document(collection = "questions")
public class NewQuestion {
    @Id
    private String questionText;
    private List<String> options;
    private String correctAnswer;

    public NewQuestion() {}
}