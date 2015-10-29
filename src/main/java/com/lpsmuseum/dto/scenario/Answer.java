package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.entity.AnswerDO;

public class Answer {
	private Long id;
	private String description;
	
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
	
	public AnswerDO getEntity() throws Exception {
		AnswerDO challengeItemDO = new AnswerDO();
		
		challengeItemDO.setDescription(description);
		challengeItemDO.setId(id);
		
		return challengeItemDO;
	}
	
}
