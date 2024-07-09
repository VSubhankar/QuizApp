package com.example.quizApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String difficulty;
    private String category;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getoptionA() {
        return optionA;
    }

    public void setoptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getoptionB() {
        return optionB;
    }

    public void setoptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getoptionC() {
        return optionC;
    }

    public void setoptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getoptionD() {
        return optionD;
    }

    public void setoptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}

