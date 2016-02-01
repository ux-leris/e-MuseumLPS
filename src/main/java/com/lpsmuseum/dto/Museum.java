package com.lpsmuseum.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lpsmuseum.behaviour.museum.Navigation;
import com.lpsmuseum.entity.MuseumDO;
import com.lpsmuseum.entity.ScenarioDO;

/**
 * This class represents a <b>museum</b>, just for transfer between client-side 
 * and server-side.
 */
public class Museum {

	/**
	 * This field represents the annotation's id.
	 */
	private Long id;
	
	/**
	 * This field represents the annotation's name.
	 */
	private String name;
	
	/**
	 * This field represents a <code>List</code> of scenarios in this museum.
	 */
	private List<Scenario> scenarios;
	
	/**
	 * This fields represents the museum's navigation.
	 * 
	 * @see Navigation
	 */
	private Navigation navigation;

	/**
	 * Class constructor.
	 */
	public Museum() {
	}

	/**
	 * Class constructor with given name and <code>List</code> of <code>Scenario
	 * </code>.
	 * 
	 * @param name the name of the museum.
	 * @param scenarios a <code>List</code> of scenarios of the <code>Museum
	 * </code> instance.
	 */
	public Museum(String name, List<Scenario> scenarios) {
		this.name = name;
		this.scenarios = scenarios;
	}

	/**
	 * Returns the <code>id</code> of this <code>Museum</code> instance.
	 *
	 * @return the <code>id</code> of this <code>Museum</code> instance.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the <code>id</code> of this <code>Museum</code> instance.
	 *
	 * @param id the <code>id</code> of this <code>Museum</code> instance.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the <code>name</code> of this <code>Museum</code> instance.
	 *
	 * @return the <code>name</code> of this <code>Museum</code> instance.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the <code>name</code> of this <code>Museum</code> instance.
	 *
	 * @param name the <code>name</code> of this <code>Museum</code> instance.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the navigation strategy of this <code>Museum</code> instance.
	 * 
	 * @return the navigation strategy of this <code>Museum</code> instance.
	 * @see Navigation
	 */
	public Navigation getNavigation() {
		return navigation;
	}

	/**
	 * Sets the navigation strategy of this <code>Museum</code> instance.
	 * 
	 * @param navigation the navigation strategy of this <code>Museum</code> 
	 * instance.
	 * @return this museum.
	 * @see Navigation
	 */
	public Museum setNavigation(Navigation navigation) {
		this.navigation = navigation;
		return this;
	}

	/**
	 * Returns the <code>List</code> of scenarios of this <code>Museum</code> 
	 * instance.
	 * 
	 * @return the <code>List</code> of scenarios of this <code>Museum</code> 
	 * instance.
	 */
	public List<Scenario> getScenarios() {
		return scenarios;
	}

	/**
	 * Sets the <code>List</code> of scenarios of this <code>Museum</code> 
	 * instance.
	 * 
	 * @param scenarios the <code>List</code> of scenarios of this <code>Museum
	 * </code> instance.
	 */
	public void setScenarios(List<Scenario> scenarios) {
		this.scenarios = scenarios;
	}

	/**
	 * Returns the entity representation (<code>MuseumDO</code>) for this <code>
	 * Museum</code> instance.
	 * 
	 * @return the entity representation (<code>MuseumDO</code>) for this <code>
	 * Museum</code> instance.
	 * @throws Exception if <code>Scenario.getEntity</code> rises a exception.
	 * @see MuseumDO
	 * @see Scenario
	 */
	public MuseumDO getEntity() throws Exception {
		MuseumDO mdo = new MuseumDO();

		mdo.setId(id);
		mdo.setName(name);
		List<ScenarioDO> sdos = new ArrayList<ScenarioDO>();
		for (Scenario scenario : scenarios) {
			sdos.add(scenario.getEntity());
		}
		mdo.setScenarios(sdos);

		return mdo;
	}

	/**
	 * Sorts the <code>scenarios</code> of this <code>Museum</code> by yours 
	 * <u>historical time</u>.
	 * 
	 * @return this <code>Museum</code> instance.
	 */
	public Museum sortScenarios() {
		Collections.sort(scenarios, new Comparator<Scenario>() {
			public int compare(Scenario scenario1, Scenario scenario2) {
				return scenario1.getHistoricalTime().compareTo(scenario2.getHistoricalTime());
			}
		});
		return this;
	}
}
