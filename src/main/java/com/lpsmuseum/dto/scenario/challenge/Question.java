package com.lpsmuseum.dto.scenario.challenge;

import com.lpsmuseum.dto.scenario.AbstractChallengeItem;


public class Question extends AbstractChallengeItem<Character> {
	public Question(Long id, String enunciation) {
		super(id, enunciation);
	}
	
	public void addAnswer(QuestionItem answer, boolean isCorrectAnswer) {
		getAnswers().add(answer);
		if (isCorrectAnswer)
			setCorrectAnswer(answer);
	}
}
