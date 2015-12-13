package com.lpsmuseum.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lpsmuseum.behaviour.museum.Navigation;
import com.lpsmuseum.entity.MuseumDO;
import com.lpsmuseum.entity.ScenarioDO;

public class Museum {
	private Long id;
	private String name;
	private List<Scenario> scenarios;
	private Navigation navigation;
	
	public Museum(){
	}
	
	public Museum(String name, List<Scenario> scenarios) {
		this.name = name;
		this.scenarios = scenarios;
	}
	
	public Museum sortScenarios() {
		Collections.sort(scenarios, new Comparator<Scenario>() {
	        public int compare(Scenario  scenario1, Scenario  scenario2)
	        {
	        	return  scenario1.getHistoricalTime().compareTo(scenario2.getHistoricalTime());
	        }
	    });
		return this;
	}

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
	
	public Navigation getNavigation() {
		return navigation;
	}
	
	public Museum setNavigation(Navigation navigation){
		this.navigation = navigation;
		return this;
	}
	
	public List<Scenario> getScenarios() {
		return scenarios;
	}

	public MuseumDO getEntity() throws Exception {
		MuseumDO mdo = new MuseumDO();
		
		mdo.setId(id);
		mdo.setName(name);
		List<ScenarioDO> sdos = new ArrayList<ScenarioDO>();
		for (Scenario scenario : scenarios)
			sdos.add(scenario.getEntity());
		mdo.setScenarios(sdos);
		
		return mdo;
	}
}
