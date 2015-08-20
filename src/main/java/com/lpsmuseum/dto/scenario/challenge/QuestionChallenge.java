package com.lpsmuseum.dto.scenario.challenge;

import com.lpsmuseum.dto.scenario.AbstractChallenge;

public class QuestionChallenge extends AbstractChallenge<Character> {

	public QuestionChallenge(Long id) {
		super(id);
	}

	@Override
	protected void initUserAnswers() {
		for (int i = 0; i < items.size(); i++)
			userAnswers.add('\0');
	}
	
	public void addQuestion(Question question) {
		items.add(question);
		userAnswers.add('\0');
	}

}
