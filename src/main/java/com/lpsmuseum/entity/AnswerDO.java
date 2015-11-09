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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "answer")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="AnswerDO")
@SuppressWarnings("serial")
public class AnswerDO implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_answer")
	private Long id;
	
	@NotNull
	@Column(name = "description")
	private String description;
	
	/*
	@OneToOne
	@JoinColumn(name = "id_challenge")
	private ScenarioDO scenario;
	*/

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
/*
	public ScenarioDO getScenario() {
		return scenario;
	}

	public void setScenario(ScenarioDO scenario) {
		this.scenario = scenario;
	}
*/	
	public Answer getDto() {
		Answer answer = new Answer();
		
		answer.setDescription(description);
		answer.setId(id);
		
		return answer;
	}

}
