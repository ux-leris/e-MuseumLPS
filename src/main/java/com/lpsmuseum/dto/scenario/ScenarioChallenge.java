package com.lpsmuseum.dto.scenario;

import java.util.List;
import java.util.Map;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.MuseumDO;
import com.lpsmuseum.entity.ScenarioChallengeDO;
import com.lpsmuseum.service.MuseologicalObjectService;
import com.lpsmuseum.service.ThemeService;

/**
 * This class represents a <u>specialization</u> of <code>Scenario</code>, just 
 * for transfer between client-side and server-side.
 */
public class ScenarioChallenge extends Scenario {
	
	/**
	 * This field represents a <code>List</code> of <code>Challenge</code> 
	 * associated with this <code>Scenario</code> instance.
	 */
	private List<Challenge> challenges;
	
	/**
	 * Class constructor.
	 * 
	 * @param name the <code>name</code> of this <code>Scenario</code> instance.
	 * @param objects the <code>List</code> of <code>MuseologicalObject</code> 
	 * associated with this <code>Scenario</code> instance.
	 * @param challenges the <code>List</code> of <code>Challenge</code> 
	 * associated with this <code>Scenario</code> instance.
	 */
	public ScenarioChallenge(String name, List<MuseologicalObject> objects, 
			List<Challenge> challenges){
		super(name, objects);
		this.challenges = challenges;
	}

	/**
	 * Returns the <code>List</code> of <code>Challenge</code> associated with 
	 * this <code>Scenario</code> instance.
	 * 
	 * @return the <code>List</code> of <code>Challenge</code> associated with 
	 * this <code>Scenario</code> instance.
	 */
	public List<Challenge> getChallenges() {
		return challenges;
	}

	/**
	 * Sets the <code>List</code> of <code>Challenge</code> associated with 
	 * this <code>Scenario</code> instance.
	 * @param challenges the <code>List</code> of <code>Challenge</code> 
	 * associated with this <code>Scenario</code> instance.
	 */
	public void setChallenges(List<Challenge> challenges) {
		this.challenges = challenges;
	}
	
	/**
	 * Should return a map with the results of the challenges. <b>Not 
	 * implemented.</b>
	 * 
	 * @return a map with the results of the challenges.
	 */
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
		scenarioChallengeDO.setTheme(getTheme().getEntity());
		
		return scenarioChallengeDO;
	}
}
