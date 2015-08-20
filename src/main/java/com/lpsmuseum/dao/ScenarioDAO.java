package com.lpsmuseum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.ScenarioDO;
import com.lpsmuseum.entity.ThemeDO;

public class ScenarioDAO extends BasicDAO {
	public void createScenario(ScenarioDO scenario){
		List<MuseologicalObjectDO> modos = new MuseologicalObjectDAO().listObjects();
		ArrayList<MuseologicalObjectDO> newmodos = new ArrayList<MuseologicalObjectDO>();
		for (MuseologicalObjectDO modo : modos)
			if (scenario.getObjects().contains(modo))
				newmodos.add(modo);
		MuseologicalObjectDAO modao = new MuseologicalObjectDAO();
		for (MuseologicalObjectDO modo : newmodos)
			modao.merge(modo);
		
		//new ThemeDAO().merge(scenario.getTheme());
		ThemeDO tdo;
		if ((tdo = (ThemeDO) new ThemeDAO().findEntity(scenario.getTheme())) != null)
				scenario.setTheme(tdo);
		
		create(scenario);
	}
	
	public void editScenario(ScenarioDO scenario){
		merge(scenario);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object findEntity(Object obj) {
		ScenarioDO sdo = (ScenarioDO) obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if(sdo.getId() != null){
			sdo = 	em.find(sdo.getClass(), sdo.getId());
		} else{
			List<ScenarioDO> sdos = (List<ScenarioDO>)em.createQuery("SELECT s FROM ScenarioDO s WHERE s.name = '" + sdo.getName()  + "'")
				.getResultList();
			sdo = sdos.isEmpty() ? null : sdos.get(0);
		}
		em.close();
		return sdo;
	}
	
	@SuppressWarnings("unchecked")
	public List<ScenarioDO> listScenarios(){
		return list("ScenarioDO");
	}
	
	public void deleteScenario(ScenarioDO scenario){
		delete(scenario);
	}

	/*@SuppressWarnings("unchecked")
	public List<ScenarioDO> listScenariosForMuseum(Long id) {
		return list("ScenarioDO", "WHERE o.museum.id = " + Long.toString(id));
	}*/
}
