package com.lpsmuseum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.ScenarioDO;

public class MuseologicalObjectDAO extends BasicDAO {
	
	public void createObject(MuseologicalObjectDO object){
		create(object);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object findEntity(Object obj) {
		MuseologicalObjectDO odo = (MuseologicalObjectDO) obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if(odo.getId() != null){
			Object xdo = em.find(MuseologicalObjectDO.class, odo.getId());
			return xdo;
		} else{
			List<MuseologicalObjectDO> odos = (List<MuseologicalObjectDO>)em.createQuery("SELECT o FROM MuseologicalObjectDO o WHERE o.name = '" + odo.getName()  + "'")
				.getResultList();
			odo = odos.isEmpty() ? null : odos.get(0);
		}
		em.close();
		return odo;
	}

	public void editObject(MuseologicalObjectDO objDO) {
		merge(objDO);		
	}
	
	@SuppressWarnings("unchecked")
	public List<MuseologicalObjectDO> listObjects(){
		return list("MuseologicalObjectDO");
	}
	
	public void deleteObject(MuseologicalObjectDO object){
		List<ScenarioDO> sdos = new ScenarioDAO().listScenarios();
		List<MuseologicalObjectDO> mdos = new ArrayList<MuseologicalObjectDO>();
		ScenarioDAO sdao =  new ScenarioDAO();
		for (ScenarioDO sdo : sdos) {
			for (MuseologicalObjectDO mdo : sdo.getObjects()) {
				if (mdo.getId().intValue() == object.getId().intValue())
					mdos.add(mdo);
			}
			for (MuseologicalObjectDO mdo : mdos) {
				sdo.getObjects().remove(mdo);
			}
			sdao.merge(sdo);
			mdos.clear();
		}
		
		//delete(MuseologicalObjectDO.class, object.getId());
		delete(object);
	}
}
