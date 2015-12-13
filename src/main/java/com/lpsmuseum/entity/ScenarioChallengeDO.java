package com.lpsmuseum.entity;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.dto.scenario.ScenarioChallenge;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue(value = "ScenarioChallengeDO")
@SuppressWarnings("serial")
public class ScenarioChallengeDO extends ScenarioDO {
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="scenario_challenge", joinColumns={@JoinColumn(name="id_scenario")}, inverseJoinColumns={@JoinColumn(name="id_challenge")})
	private List<ChallengeDO> challenges;

	public List<ChallengeDO> getChallenges() {
		return challenges;
	}

	public void setChallenges(List<ChallengeDO> challenges) {
		this.challenges = challenges;
	}

	@Override
	public ScenarioChallenge getDto() {
		ScenarioChallenge scenarioChallenge;
		
		List<MuseologicalObject> objects = new ArrayList<MuseologicalObject>();
		for (MuseologicalObjectDO object : getObjects())
			objects.add(object.getDto());
		List<Challenge> challenges = new ArrayList<Challenge>();
		for (ChallengeDO challenge : this.challenges)
			challenges.add(challenge.getDto());
		scenarioChallenge = new ScenarioChallenge(getName(), objects, challenges);
		scenarioChallenge.setId(getId());
		scenarioChallenge.setTheme(getTheme().getDto());
		
		return scenarioChallenge;
	}
	
	
}
