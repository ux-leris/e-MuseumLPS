package com.lpsmuseum.service.builders;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.behaviour.museum.Navigation;
import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.service.AnnotationService;
import com.lpsmuseum.service.MuseumService;

public class MuseumBuilder {
	List<Scenario> scenarios = new ArrayList<Scenario>();
	ArrayList<Annotation> annotations = new ArrayList<Annotation>();
	Navigation navigation;
	
	public Museum build(String name) throws Exception{
		Museum m = new Museum(name, scenarios)
				.setNavigation(navigation)
				.sortScenarios();
		MuseumService svc = new MuseumService();
		svc.createMuseum(m);
		AnnotationService as = new AnnotationService();
		for(Annotation a : annotations){
			a.setIdMuseum(m.getId());
			as.createAnnotation(a);
		}
		return m;
	}
	
	public MuseumBuilder withScenario(Scenario scenario){
		scenarios.add(scenario);
		return this;
	}
	
	public MuseumBuilder withNavigation(Navigation navigation){
		this.navigation = navigation;
		return this;
	}
	
	public MuseumBuilder withAnnotation(Annotation annotation){
		annotations.add(annotation);
		return this;
	}

	public void clear() {
		annotations.clear();
		scenarios.clear();
		navigation = null;
	}
}
