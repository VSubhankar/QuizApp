package com.quizapp.quizAppSB.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.List;

@Data
@Document(collection = "quizzes")
public class Quiz {
    @Id
    private Integer id;
    private String title;
    private List<Question> questions; // Embedded question objects
}

