package com.lpsmuseum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.lpsmuseum.dto.scenario.Answer;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.InheritanceType;

/**
 * An entity class for answer's table (with name <code>answer</code>). The 
 * table has columns for:
 * <ul>
 * <li>An id
 * <li>A description
 * <li>A value indicating if is correct
 * </ul>
 *
 * @serial
 */
@Entity
@Table(name = "answer")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="AnswerDO")
@SuppressWarnings("serial")
public class AnswerDO implements Serializable {
	
	/**
	 * This field is the <b>primary key</b> of the table (so can't be null by
	 * default) and is <u>auto generated</u> sequentially. The column's name in
	 * the table is <code>id_answer</code>.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_answer")
	private Long id;
	
	/**
	 * This field represents the theme's description. The column's name in the
	 * table is <code>description</code>.
	 */
	@NotNull
	@Column(name = "description")
	private String description;
	
	/**
	 * This field indicate if this answer is correct or no. The column's name 
	 * in the table is <code>correct</code>.
	 */
	@Column(name = "correct")
	private Boolean correct;

	/**
	 * Class constructor.
	 */
	public AnswerDO() {
	}

	/**
	 * Returns the id of the theme.
	 *
	 * @return the id of the theme.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id of this theme.
	 *
	 * @param id the id of this theme.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the description of this theme.
	 *
	 * @return the description of this theme.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of this theme.
	 *
	 * @param description the description of this theme.
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
	 * Returns the transfer object representing this theme.
	 *
	 * @return the transfer object representing this museum.
	 */
	public Answer getDto() {
		Answer answer = new Answer();
		
		answer.setDescription(description);
		answer.setId(id);
		answer.setCorrect(correct);
		
		return answer;
	}

}
