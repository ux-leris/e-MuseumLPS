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

import com.lpsmuseum.dto.scenario.AbstractChallengeItem;

@SuppressWarnings("serial")
@Entity
@Inheritance
@Table(name = "answer")
public abstract class ChallengeItemDO implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_answer")
	private Long id;
	
	@NotNull
	@Column(name = "description")
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
	
	public abstract AbstractChallengeItem getDto();

}
