package ua.com.library.dto;

public class AnswerDto {
	private int id;
	private String text;
	private boolean correct;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public AnswerDto(int id, String text, boolean correct) {
		super();
		this.id = id;
		this.text = text;
		this.correct = correct;
	}
	
	
}
