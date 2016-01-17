package com.lpsmuseum.entity;

import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.dto.scenario.Answer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * An entity class for challenge's table (with name <code>challenge</code>). 
 * The table has columns for:
 * <ul>
 * <li>An id
 * <li>A description
 * </ul>
 * <p>
 * Regardless of this, the challenge's table has one many-to-many relationship
 * with answer's table, whom generate the table scenario_challenge.
 *
 * @serial
 * @see AnswerDO
 */
@Entity
@Table(name = "challenge")
@Inheritance
@SuppressWarnings("serial")
public class ChallengeDO implements Serializable {

	/**
	 * This field is the <b>primary key</b> of the table (so can't be null by
	 * default) and is <u>auto generated</u> sequentially. The column's name in
	 * the table is <code>id_challenge</code>.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_challenge")
	private Long id;

	/**
	 * This field represents the challenge's description. The column's name in 
	 * the table is <code>description</code>.
	 */
	@Column(name = "description")
	private String description;

	/**
	 * This field represents the many-to-many relationship between challenge 
	 * and answer's table. The relationship generate the table <code>
	 * challenge_answer</code>, doing the join with respective id of each 
	 * table.
	 * <p>
	 * The fetch type for the objects of type <code>AnswerDO</code> is <b>eager
	 * </b>, so all the objects are loaded only once.
	 *
	 * @see FetchType
	 * @see AnswerDO
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "challenge_answer", joinColumns = {
		@JoinColumn(name = "id_challenge")}, inverseJoinColumns = {
		@JoinColumn(name = "id_answer")})
	private List<AnswerDO> answers;

	/**
	 * Class constructor.
	 * <p>
	 * Initializes this with a empty list of answers.
	 */
	public ChallengeDO() {
		answers = new ArrayList<AnswerDO>();
	}

	/**
	 * Returns the id of this challenge.
	 *
	 * @return the id of this challenge.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id of this challenge.
	 *
	 * @param id the id of this challenge.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the description of this challenge.
	 *
	 * @return the description of this challenge.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of this challenge.
	 *
	 * @param description the description of this challenge.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the list of answers (entity like) related to this challenge.
	 *
	 * @return the list of answers related to this challenge.
	 */
	public List<AnswerDO> getAnswers() {
		return answers;
	}

	/**
	 * Sets the list of answers (entity like) related to this challenge.
	 * 
	 * @param answers the list of answers related to this challenge.
	 */
	public void setAnswers(List<AnswerDO> answers) {
		this.answers = answers;
	}

	/**
	 * Returns the transfer object representing this challenge.
	 *
	 * @return the transfer object representing this challenge.
	 */
	public Challenge getDto() {
		Challenge c = new Challenge();
		
		c.setChallengeId(id);
		c.setDescription(description);
		List<Answer> challengeItems = new ArrayList<Answer>();
		for (AnswerDO answer : answers) {
			challengeItems.add(answer.getDto());
		}
		c.setAnswers(challengeItems);
		
		return c;
	}
}
