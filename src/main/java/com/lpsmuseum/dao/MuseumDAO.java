package com.lpsmuseum.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.lpsmuseum.entity.MuseumDO;

/**
 * This class provides a easy way to work with persistence of museums.
 * <p>
 * All the <b>CRUD (Create, Retrieve, Update and Delete)</b> operations are 
 * supported.
 * @see BasicDAO
 */
public class MuseumDAO extends BasicDAO {

	@Override
	@SuppressWarnings("unchecked")
	public Object findEntity(Object obj) {
		MuseumDO mdo = (MuseumDO) obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if (mdo.getId() != null) {
			mdo = em.find(mdo.getClass(), mdo.getId());
		} else {
			List<MuseumDO> mdos = (List<MuseumDO>) em.createQuery(
					"SELECT m "
					+ "FROM MuseumDO m "
					+ "WHERE m.name = '" + mdo.getName() + "'"
			).getResultList();
			mdo = mdos.isEmpty() ? null : mdos.get(0);
		}
		em.close();
		return mdo;
	}

	/**
	 * <b>Persists</b> a <b>new</b> museum to the datadase, <u>if only if</u>
	 * the object is not persisted yet.
	 *
	 * @param museum the museum to be persisted.
	 */
	public void createMuseum(MuseumDO museum) {
		create(museum);
	}

	/**
	 * <b>Merge</b> the museum's state to the database.
	 *
	 * @param museum the museum to have your state updated on the database.
	 */
	public void editMuseum(MuseumDO museumDO) {
		merge(museumDO);
	}

	/**
	 * Lists <b>all</b> the persisted museums.
	 *
	 * @return the <code>List</code> with <b>all</b> persisted museums.
	 */
	@SuppressWarnings("unchecked")
	public List<MuseumDO> listMuseums() {
		return list("MuseumDO");
	}

	/**
	 * <b>Delete</b> the <u>persisted</u> museum from the database.
	 *
	 * @param museum the museum to be deleted.
	 */
	public void deleteMuseum(MuseumDO museum) {
		delete(museum);
	}
}
