package com.lpsmuseum.service.builders;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.dto.scenario.ScenarioChallenge;
import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.service.ScenarioService;

public class ScenarioBuilder {
	private List<MuseologicalObject> objects = new ArrayList<MuseologicalObject>();
	@SuppressWarnings("rawtypes")
	private List<Challenge> challenges;
	private Theme theme = null;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Scenario build(String name) throws Exception
	{
		Scenario s;
		if(challenges != null)
			s = new ScenarioChallenge(name, objects, challenges);
		else s = new Scenario(name, objects);
		if(theme == null) throw new Exception("Theme must not be null!");
		s.setTheme(theme);
		ScenarioService svc = new ScenarioService();
		svc.createScenario(s);
		return s;
	}
	
	public ScenarioBuilder withObject(MuseologicalObject obj)
	{
		objects.add(obj);
		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public ScenarioBuilder withChallenge(Challenge challenge)
	{
		challenges.add(challenge);
		return this;
	}
	
	public ScenarioBuilder withTheme(Theme theme)
	{
		this.theme = theme;
		return this;
	}
	
	public ScenarioBuilder clear() {
		challenges = null;
		objects.clear();
		theme = null;
		return this;
	}
}
