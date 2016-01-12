package com.lpsmuseum.service;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dao.ScenarioDAO;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.entity.ScenarioDO;

public class ScenarioService {
	ScenarioDAO dao = new ScenarioDAO();
	
	public void createScenario(Scenario scenario) throws Exception{
		ScenarioDO scenarioDO = scenario.getEntity();
		dao.createScenario(scenarioDO);
		scenario.setId(scenarioDO.getId());
	}
	
	public Scenario findById(Long id){
		Scenario s = new Scenario();
		s.setId(id);
		ScenarioDO sdo = findEntity(s);
		return (sdo == null) ? null : sdo.getDto();
	}
	
	public Scenario findByName(String name){
		Scenario s = new Scenario();
		s.setName(name);
		ScenarioDO sdo = findEntity(s);
		return sdo.getDto();
	}
	
	public ScenarioDO findEntity(Scenario scenario){
		ScenarioDO sdo = new ScenarioDO();
		sdo.setId(scenario.getId());
		sdo.setName(scenario.getName());
		return (ScenarioDO)dao.findEntity(sdo);
	}

	public void editScenario(Scenario scenario) throws Exception {
		ScenarioDO sdo = scenario.getEntity();
		dao.editScenario(sdo);
	}
	
	public ArrayList<Scenario> listScenarios(){
		List<ScenarioDO> sdos = dao.listScenarios();
		ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
		for(ScenarioDO sdo : sdos){
			Scenario s = sdo.getDto();
			scenarios.add(s);
		}
		return scenarios;
	}
	
	public void deleteScenario(Long id){
		ScenarioDO scenario = new ScenarioDO();
		scenario.setId(id);
		dao.deleteScenario(scenario);
	}

	/*public List<Scenario> listScenariosForMuseum(Long id) {
		List<ScenarioDO> sdos = dao.listScenariosForMuseum(id);
		ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
		for(ScenarioDO sdo : sdos){
			Scenario s = sdo.getDto();
			scenarios.add(s);
		}
		return scenarios;
	}*/
}
