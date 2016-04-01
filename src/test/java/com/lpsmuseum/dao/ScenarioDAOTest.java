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
        for (int i = 0; i < scenarios.size(); i++) {
            Scenario scenario = scenarios.get(i);
            scenario = ((ScenarioDO) dao.findEntity(scenario.getEntity())).getDto();
            assertNotNull(scenario);
            scenarios.get(i).setId(scenario.getId());
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
        for (int i = 0; i < scenarios.size(); i++) {
            Scenario scenario = scenarios.get(i);
            ScenarioDO scenarioDO = scenariosDO.get(i);
            assertNotSame(scenario.getName(), scenarioDO.getName());
            assertNotNull(scenario);
            scenarios.get(i).setId(scenario.getId());
        }

        /*
	 * Deleting
         */
        int expected = scenariosDO.size() - scenarios.size();
        for (int i = 0; i < scenarios.size(); i++) {
            Scenario scenario = scenarios.get(i);
            for (ScenarioDO scenarioDO : scenariosDO)
                if (scenario.getId().equals(scenarioDO.getId())) {
                    dao.deleteScenario(scenarioDO);
                    break;
                }
        }

        scenariosDO = dao.listScenarios();
        assertNotNull(scenariosDO);
        assertEquals(expected, scenariosDO.size());
    }

}
