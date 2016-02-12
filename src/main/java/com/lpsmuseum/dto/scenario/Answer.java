package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.entity.AnswerDO;

/**
 * This class represents an <b>answer</b>, just for transfer between 
 * client-side and server-side.
 */
public class Answer {
	/**
	 * This field represents the answer's id.
	 */
	private Long id;
	
	/**
	 * This fields represents the answer's description.
	 */
	private String description;
	
	/**
	 * This fields indicatef the answer is correct or no.
	 */
	private Boolean correct;

	/**
	 * Class constructor.
	 */
	public Answer() {
	}
	
	/**
	 * Returns the <code>id</code> of this <code>Answer</code> instance.
	 *
	 * @return the <code>id</code> of this <code>Answer</code> instance.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the <code>id</code> of this <code>Answer</code> instance.
	 *
	 * @param id the <code>id</code> of this <code>Answer</code> instance.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Returns the <code>description</code> of this <code>Answer</code> instance.
	 * 
	 * @return the <code>description</code> of this <code>Answer</code> instance.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the <code>description</code> of this <code>Answer</code> instance.
	 * 
	 * @param description  the <code>description</code> of this <code>Answer
	 * </code> instance.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns if this answer is correct or no.
	 * 
	 * @return true if this answer is correct, otherwise false.
	 */
	public Boolean isCorrect() {
		return correct;
	}

	/**
	 * Sets if this answer is correct or no.
	 * 
	 * @param correct true if this answer is correct, otherwise false.
	 */
	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	
	/**
	 * Returns the entity representation (<code>AnswerDO</code>) for this 
	 * <code>Answer</code> instance.
	 * 
	 * @return the entity representation (<code>AnswerDO</code>) for this 
	 * <code>Answer</code> instance.
	 * @see AnswerDO
	 */
	public AnswerDO getEntity() throws Exception {
		AnswerDO answerDO = new AnswerDO();
	
		answerDO.setCorrect(correct);
		answerDO.setDescription(description);
		answerDO.setId(id);
		
		return answerDO;
	}
	
}
