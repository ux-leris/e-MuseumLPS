package com.lpsmuseum.dto.scenario;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractChallengeItem<T> {
	private Long id;
	private String enunciation;
	private List<Comparable<T>> answers;
	private int correctAnswer;
	
	public AbstractChallengeItem(Long id, String enunciation) {
		this.id = id;
		this.enunciation = enunciation;
		
		this.answers = new ArrayList<Comparable<T>>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnunciation() {
		return enunciation;
	}

	public void setEnunciation(String enunciation) {
		this.enunciation = enunciation;
	}

	public List<Comparable<T>> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Comparable<T>> answers) {
		this.answers = answers;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Comparable<T> correctAnswer) {
		if (!answers.contains(correctAnswer))
			answers.add(correctAnswer);
		this.correctAnswer = answers.indexOf(correctAnswer);
	}

	public boolean checkAnswer(T t) {
		return 0 == answers.get(correctAnswer).compareTo(t);
	}
	
}
