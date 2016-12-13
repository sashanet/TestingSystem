package ua.com.library.dto;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ua.com.library.entity.Answer;
import ua.com.library.entity.Test;

public class QuestionDto {
	private int id;
	private String name;
	private String question;
	private int points;


	 
	public QuestionDto() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public QuestionDto(int id, String name, String question, int points) {
		super();
		this.id = id;
		this.name = name;
		this.question = question;
		this.points = points;
	}
	
	 
	 
	 
}
