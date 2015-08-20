package com.lpsmuseum.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@SuppressWarnings("serial")
public class ScenarioChallengeDO extends ScenarioDO {
	@OneToMany
	@JoinColumn(name="id_scenario")
	private List<ChallengeDO> challenges;
}
