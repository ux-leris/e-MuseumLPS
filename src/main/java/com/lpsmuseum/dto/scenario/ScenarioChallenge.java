package com.lpsmuseum.dto.scenario;

import java.util.List;
import java.util.Map;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.MuseumDO;
import com.lpsmuseum.entity.ScenarioChallengeDO;
import com.lpsmuseum.entity.ScenarioDO;
import com.lpsmuseum.service.MuseologicalObjectService;
import com.lpsmuseum.service.ThemeService;

public class ScenarioChallenge extends Scenario {
	private List<Challenge> challenges;
	
	public ScenarioChallenge(String name, List<MuseologicalObject> objects, List<Challenge> challenges){
		super(name, objects);
		this.challenges = challenges;
	}

	public List<Challenge> getChallenges() {
		return challenges;
	}

	public void setChallenges(List<Challenge> challenges) {
		this.challenges = challenges;
	}
	
	public Map<Long, Boolean> getResult() {
		return null;//challenge.getResult();
	}
	
	@Override
	public ScenarioChallengeDO getEntity() throws Exception{
		ScenarioChallengeDO scenarioChallengeDO = new ScenarioChallengeDO();
		scenarioChallengeDO.setName(getName());
		scenarioChallengeDO.setId(getId());
		Long idMuseum = getId();
		if(idMuseum != null){
			MuseumDO mdo = new MuseumDO();
			mdo.setId(idMuseum);
			scenarioChallengeDO.setMuseum(mdo);
		}
		MuseologicalObjectService svc = new MuseologicalObjectService();
		for(MuseologicalObject obj : getObjects()){
			MuseologicalObjectDO objDO = svc.findEntity(obj);
			if(objDO != null) scenarioChallengeDO.getObjects().add(objDO);
			else throw new Exception("Could not find object " + obj.getName() + "!");
		}
		scenarioChallengeDO.setTheme(new ThemeService().getEntity(getTheme()));
		return scenarioChallengeDO;
	}
}
