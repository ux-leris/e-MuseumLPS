package com.lpsmuseum.dto.scenario.challenge;

public class QuestionItem implements Comparable<Character> {
	
	private Character id;
	private String description;

	public QuestionItem(char id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Character getId() {
		return id;
	}

	public void setId(Character id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(Character c) {
		return id.compareTo(c);
	}
}
