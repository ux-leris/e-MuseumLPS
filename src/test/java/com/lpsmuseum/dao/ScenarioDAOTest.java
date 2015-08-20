package com.lpsmuseum.dao;

import java.util.List;

import junit.framework.TestCase;

import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.entity.ScenarioDO;

public class ScenarioDAOTest extends TestCase {
	List<Scenario> scenarios;

	protected void setUp() throws Exception {
		scenarios = DAOTestUtil.generateScenarios();
	}

	public void testCRUD() throws Exception {
		assertNotNull(scenarios);

		ScenarioDAO dao = new ScenarioDAO();
		assertNotNull(dao);

		//List<ScenarioDO> scenariosDO;

		/*
		 * Creating
		 */

		// Are the scenarios persisting?
		for (Scenario scenario : scenarios) {
			assertNotNull(scenario);
			ScenarioDO scenarioDO = scenario.getEntity();
			assertNotNull(scenarioDO);
			dao.createScenario(scenarioDO);
		}

		// Are the scenarios persisted?
		List<ScenarioDO> scenariosDO = dao.listScenarios();
		assertNotNull(scenariosDO);
		for (Scenario object : scenarios) {
			boolean match = false;
			for (ScenarioDO objectDO : scenariosDO) {
				if (object.getEntity().getId() == objectDO.getId()) {
					match = true;
					break;
				}
			}
			assertTrue(match);
			// TODO scenariosDO possui menos um registro do que a tabela mapeada.
		}

		/*
		 * Editing
		 */

		// Can scenarios be modified and persisted?
		for (Scenario scenario : scenarios) {
			assertNotNull(scenario);
			scenario.setName(scenario.getName().concat("test"));
			ScenarioDO scenarioDO = scenario.getEntity();
			assertNotNull(scenarioDO);
			dao.editScenario(scenarioDO);
		}

		// Are the scenarios modified and persisting?
		scenariosDO = dao.listScenarios();
		assertNotNull(scenariosDO);
		for (Scenario scenario : scenarios) {
			boolean match = false;
			for (ScenarioDO scenarioDO : scenariosDO) {
				if (scenario.getEntity().getId() == scenarioDO.getId()) {
					match = true;
					break;
				}
			}
			assertTrue(match);
		}

		/*
		 * Deleting
		 */

		for (Scenario scenario : scenarios) {
			assertNotNull(scenario);
			ScenarioDO scenarioDO = scenario.getEntity();
			assertNotNull(scenarioDO);
			dao.deleteScenario(scenarioDO);
		}

		scenariosDO = dao.listScenarios();
		assertNotNull(scenariosDO);
		for (Scenario scenario : scenarios) {
			boolean match = false;
			for (ScenarioDO scenarioDO : scenariosDO) {
				if (scenario.getEntity().getId() == scenarioDO.getId()) {
					match = true;
					break;
				}
			}
			assertFalse(match);
		}
	}

}
