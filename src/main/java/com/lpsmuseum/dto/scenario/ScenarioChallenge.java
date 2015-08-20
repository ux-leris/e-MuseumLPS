package com.lpsmuseum.dto.scenario;

import java.util.List;
import java.util.Map;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;

public class ScenarioChallenge extends Scenario {
	private List<Challenge> challenges;
	
	public ScenarioChallenge(String name, List<MuseologicalObject> objects, List<Challenge> challenges){
		super(name, objects);
		this.challenges = challenges;
	}

	public List<Challenge> getChallenges() {
		return challenges;
	}

	public void setChallenges(List<Challenge> challenge) {
		this.challenges = challenges;
	}
	
	public Map<Long, Boolean> getResult() {
		return null;//challenge.getResult();
	}
}
