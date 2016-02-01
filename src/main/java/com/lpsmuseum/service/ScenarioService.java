package com.lpsmuseum.service;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dao.ScenarioDAO;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.entity.ScenarioDO;

/**
 * This class provides services to work with <b>scenarios</b>.
 *
 * <p>
 * The services available are all the CRUD operations.
 *
 * @see Scenario
 */
public class ScenarioService {

	/**
	 * This fields provides communication with the database.
	 */
	private final ScenarioDAO dao = new ScenarioDAO();

	/**
	 * Class constructor.
	 */
	public ScenarioService() {
	}

	/**
	 * Creates a new register in the database for a <code>Scenario</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Scenario scenario = new Scenario();
	 * // Getters call on scenario
	 * ScenarioService service = new ScenarioService();
	 * service.createScenario(scenario);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param scenario the <code>Scenario</code> instance to be registered in
	 * the database.
	 */
	public void createScenario(Scenario scenario) throws Exception {
		ScenarioDO scenarioDO = scenario.getEntity();
		dao.createScenario(scenarioDO);
		scenario.setId(scenarioDO.getId());
	}

	/**
	 * Searchs for the scenario with given <code>id</code>.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Long id = 1L;
	 * ScenarioService service = new ScenarioService();
	 * Scenario scenario = service.findById(id);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param id the id of the scenario.
	 * @return the <code>Scenario</code> instance representing a register in 
	 * the database with given <code>id</code>. If the register can't be found, 
	 * <code>null</code> is returned.
	 */
	public Scenario findById(Long id) {
		Scenario s = new Scenario();
		s.setId(id);
		ScenarioDO sdo = findEntity(s);
		return (sdo == null) ? null : sdo.getDto();
	}

	/**
	 * Searchs for the scenario with given <code>name</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * String name = "Computers";
	 * ScenarioService service = new ScenarioService();
	 * Scenario scenario = service.findByName(name);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param name the name of the scenario.
	 * @return the <code>Scenario</code> instance representing a register in the
	 * database with given <code>name</code>. If the register can't be found,
	 * <code>null</code> is returned.
	 */
	public Scenario findByName(String name) {
		Scenario s = new Scenario();
		s.setName(name);
		ScenarioDO sdo = findEntity(s);
		return sdo.getDto();
	}

	/**
	 * Finds the entity corresponding to given <code>Scenario</code>.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Scenario scenario = new Scenario();
	 * scenario.setId(1L);
	 * ScenarioService service = new ScenarioService();
	 * ScenarioDO scenarioDO = service.findEntity(scenario);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param scenario the scenario to be searched.
	 * @return the entity instance of given <code>Scenario</code>.
	 */
	public ScenarioDO findEntity(Scenario scenario) {
		ScenarioDO sdo = new ScenarioDO();
		sdo.setId(scenario.getId());
		sdo.setName(scenario.getName());
		return (ScenarioDO) dao.findEntity(sdo);
	}

	/**
	 * Updates an <code>Scenario</code> stored in the database.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * ScenarioService service = new ScenarioService();
	 * Scenario scenario = service.finByTitle("Computers");
	 * scenario.setTitle("Computers and laptops");
	 * service.editScenario(scenario);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param scenario the <cod>Scenario<code> to be updated.
	 */
	public void editScenario(Scenario scenario) throws Exception {
		ScenarioDO sdo = scenario.getEntity();
		dao.editScenario(sdo);
	}

	/**
	 * Lists all the scenarios.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * ScenarioService service = new ScenarioService();
	 * List&lt;Scenario&gt; scenarios = service.listScenarios();
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @return the <code>List</code> of all <code>Scenario</code> stored in the 
	 * database.
	 */
	public List<Scenario> listScenarios() {
		List<ScenarioDO> sdos = dao.listScenarios();
		ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
		for (ScenarioDO sdo : sdos) {
			Scenario s = sdo.getDto();
			scenarios.add(s);
		}
		return scenarios;
	}

	/**
	 * Deletes an <code>Scenario</code> stored in the database.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * ScenarioService service = new ScenarioService();
	 * Scenario scenario = service.finByName("Computers");
	 * service.deleteAnnotation(scenario.getId());
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param id the <code>id</code> of <code>Scenario</code> to be deleted.
	 */
	public void deleteScenario(Long id) {
		ScenarioDO scenario = new ScenarioDO();
		
		scenario.setId(id);
		
		dao.deleteScenario(scenario);
	}
	
}
