package com.example.quizApp.model;

import lombok.Data;

@Data
public class QuestionWrapper {

    private Integer id;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;


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
	
	public QuestionWrapper(Integer id, String title, String optionA, String optionB, String optionC, String optionD) {
        this.setId(id);
        this.setTitle(title);
        this.setoptionA(optionA);
        this.setoptionB(optionB);
        this.setoptionC(optionC);
        this.setoptionD(optionD);
    }
}