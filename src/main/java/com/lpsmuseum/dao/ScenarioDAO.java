package com.lpsmuseum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.ScenarioDO;
import com.lpsmuseum.entity.ThemeDO;

/**
 * This class provides a easy way to work with persistence of scenarios.
 * <p>
 * All the <b>CRUD (Create, Retrieve, Update and Delete)</b> operations are 
 * supported.
 * @see BasicDAO
 */
public class ScenarioDAO extends BasicDAO {

	@Override
	@SuppressWarnings("unchecked")
	public Object findEntity(Object obj) {
		ScenarioDO sdo = (ScenarioDO) obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if (sdo.getId() != null) {
			sdo = em.find(sdo.getClass(), sdo.getId());
		} else {
			List<ScenarioDO> sdos = (List<ScenarioDO>) em.createQuery(
					"SELECT s "
					+ "FROM ScenarioDO s "
					+ "WHERE s.name = '" + sdo.getName() + "'"
			).getResultList();
			sdo = sdos.isEmpty() ? null : sdos.get(0);
		}
		em.close();
		return sdo;
	}

	/**
	 * <b>Persists</b> a <b>new</b> scenario to the datadase, <u>if only if</u>
	 * the object is not persisted yet.
	 *
	 * @param scenario the scenario to be persisted.
	 */
	public void createScenario(ScenarioDO scenario) {
		List<MuseologicalObjectDO> modos = new MuseologicalObjectDAO().listObjects();
		ArrayList<MuseologicalObjectDO> newmodos = new ArrayList<MuseologicalObjectDO>();
		for (MuseologicalObjectDO modo : modos) {
			if (scenario.getObjects().contains(modo)) {
				newmodos.add(modo);
			}
		}
		MuseologicalObjectDAO modao = new MuseologicalObjectDAO();
		for (MuseologicalObjectDO modo : newmodos) {
			modao.merge(modo);
		}

		//new ThemeDAO().merge(scenario.getTheme());
		ThemeDO tdo;
		if ((tdo = (ThemeDO) new ThemeDAO().findEntity(scenario.getTheme())) != null) {
			scenario.setTheme(tdo);
		}

		create(scenario);
	}

	/**
	 * <b>Merge</b> the scenario's state to the database.
	 *
	 * @param scenario the scenario to have your state updated on the database.
	 */
	public void editScenario(ScenarioDO scenario) {
		merge(scenario);
	}

	/**
	 * <b>Delete</b> the <u>persisted</u> delete from the database.
	 *
	 * @param scenario the scenario to be deleted.
	 */
	public void deleteScenario(ScenarioDO scenario) {
		delete(scenario);
	}

	/**
	 * Lists <b>all</b> the persisted scenarios.
	 *
	 * @return the <code>List</code> with <b>all</b> persisted scenarios.
	 */
	@SuppressWarnings("unchecked")
	public List<ScenarioDO> listScenarios() {
		return list("ScenarioDO");
	}
}
