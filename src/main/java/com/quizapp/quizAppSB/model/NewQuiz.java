package com.quizapp.quizAppSB.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "quizzes")
public class NewQuiz {
    @Id
    private String title;
    private List<Integer> questions; // Embedded question objects
}
