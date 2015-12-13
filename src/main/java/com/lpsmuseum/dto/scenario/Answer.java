package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.entity.AnswerDO;

public class Answer {
	private Long id;
	private String description;
	private Boolean correct;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean isCorrect() {
		return correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	
	public AnswerDO getEntity() throws Exception {
		AnswerDO answerDO = new AnswerDO();
	
		answerDO.setCorrect(correct);
		answerDO.setDescription(description);
		answerDO.setId(id);
		
		return answerDO;
	}
	
}
