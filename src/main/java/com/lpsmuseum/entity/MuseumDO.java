package com.lpsmuseum.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="museum")
@SuppressWarnings("serial")
public class MuseumDO implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_museum")
	private Long id;
	@NotNull
	@Column(name="name")
	private String name;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id_museum")
	private List<ScenarioDO> scenarios;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ScenarioDO> getScenarios() {
		return scenarios;
	}
	public void setScenarios(List<ScenarioDO> scenarios) {
		this.scenarios = scenarios;
	}
}
