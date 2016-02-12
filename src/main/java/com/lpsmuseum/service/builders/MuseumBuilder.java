package com.lpsmuseum.service.builders;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.behaviour.museum.Navigation;
import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.service.AnnotationService;
import com.lpsmuseum.service.MuseumService;

/**
 * This class provides a <b>builder</b> to creates <code>Museum</code>.
 * 
 * @see Museum
 */
public class MuseumBuilder {
	private final List<Scenario> scenarios = new ArrayList<Scenario>();
	private final List<Annotation> annotations = new ArrayList<Annotation>();
	private Navigation navigation;
	
	/**
	 * Builds a <code>Museum</code> instance with actual state.
	 * 
	 * @param name the <code>name</code> of the museum.
	 * @return the builded <code>Museum</code> instance.
	 * @throws Exception if <code>Museum.getEntity</code> rises a exception.
	 * @see Museum
	 */
	public Museum build(String name) throws Exception {
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
	
	/**
	 * Adds a new scenario to be related to the <code>Museum</code> instance 
	 * to be builded.
	 * 
	 * @param scenario the <code>Scenario</code> to be added.
	 * @return this builder instance itself.
	 */
	public MuseumBuilder withScenario(Scenario scenario){
		scenarios.add(scenario);
		return this;
	}
	
	/**
	 * Sets the navigation mode of the museum.
	 * 
	 * @param navigation the navigation mode of the museum.
	 * @return this builder instance itself.
	 */
	public MuseumBuilder withNavigation(Navigation navigation){
		this.navigation = navigation;
		return this;
	}
	
	/**
	 * Adds a new annotation to be related to the <code>Museum</code> instance 
	 * to be builded.
	 * 
	 * @param annotation the <code>Annotation</code> to be added.
	 * @return this builder instance itself.
	 */
	public MuseumBuilder withAnnotation(Annotation annotation){
		annotations.add(annotation);
		return this;
	}

	/**
	 * Clears the state of this builder.
	 * 
	 * @return this builder instance itself.
	 */
	public void clear() {
		annotations.clear();
		scenarios.clear();
		navigation = null;
	}
}
