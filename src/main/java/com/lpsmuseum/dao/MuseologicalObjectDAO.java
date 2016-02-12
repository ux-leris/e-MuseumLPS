package com.lpsmuseum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.ScenarioDO;

/**
 * This class provides a easy way to work with persistence of museological 
 * objects.
 * <p>
 * All the <b>CRUD (Create, Retrieve, Update and Delete)</b> operations are 
 * supported.
 * @see BasicDAO
 */
public class MuseologicalObjectDAO extends BasicDAO {

	@Override
	@SuppressWarnings("unchecked")
	public Object findEntity(Object obj) {
		MuseologicalObjectDO odo = (MuseologicalObjectDO) obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if (odo.getId() != null) {
			Object xdo = em.find(MuseologicalObjectDO.class, odo.getId());
			return xdo;
		} else {
			List<MuseologicalObjectDO> odos
					= (List<MuseologicalObjectDO>) em.createQuery(
							"SELECT o "
							+ "FROM MuseologicalObjectDO o "
							+ "WHERE o.name = '" + odo.getName() + "'"
					).getResultList();
			odo = odos.isEmpty() ? null : odos.get(0);
		}
		em.close();
		return odo;
	}

	/**
	 * <b>Persists</b> a <b>new</b> museological object to the datadase, <u>if
	 * only if</u> the object is not persisted yet.
	 *
	 * @param object the museological object to be persisted.
	 */
	public void createObject(MuseologicalObjectDO object) {
		create(object);
	}

	/**
	 * <b>Merge</b> the museological object's state to the database.
	 *
	 * @param object the museological object to have your state updated on the
	 * database.
	 */
	public void editObject(MuseologicalObjectDO objDO) {
		merge(objDO);
	}

	/**
	 * Lists <b>all</b> the persisted museological objects.
	 *
	 * @return the <code>List</code> with <b>all</b> persisted museological
	 * objects.
	 */
	@SuppressWarnings("unchecked")
	public List<MuseologicalObjectDO> listObjects() {
		return list("MuseologicalObjectDO");
	}

	/**
	 * <b>Delete</b> the <u>persisted</u> museological object from the database.
	 *
	 * @param object the museological object to be deleted.
	 */
	public void deleteObject(MuseologicalObjectDO object) {
		List<ScenarioDO> sdos = new ScenarioDAO().listScenarios();
		List<MuseologicalObjectDO> mdos = new ArrayList<MuseologicalObjectDO>();
		ScenarioDAO sdao = new ScenarioDAO();

		for (ScenarioDO sdo : sdos) {
			for (MuseologicalObjectDO mdo : sdo.getObjects()) {
				if (mdo.getId().intValue() == object.getId().intValue()) {
					mdos.add(mdo);
				}
			}
			for (MuseologicalObjectDO mdo : mdos) {
				sdo.getObjects().remove(mdo);
			}
			sdao.merge(sdo);
			mdos.clear();
		}

		delete(object);
	}
}
