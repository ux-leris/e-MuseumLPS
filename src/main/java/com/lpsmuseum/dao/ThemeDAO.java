package com.lpsmuseum.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.lpsmuseum.entity.ThemeDO;

/**
 * This class provides a easy way to work with persistence of themes.
 * <p>
 * All the <b>CRUD (Create, Retrieve, Update and Delete)</b> operations are 
 * supported.
 * @see BasicDAO
 */
public class ThemeDAO extends BasicDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Object findEntity(Object obj) {
		ThemeDO tdo = (ThemeDO) obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if (tdo.getId() != null) {
			tdo = em.find(tdo.getClass(), tdo.getId());
		} else {
			List<ThemeDO> tdos = (List<ThemeDO>) em.createQuery("SELECT t FROM ThemeDO t WHERE t.title = '" + tdo.getTitle() + "'").getResultList();
			tdo = tdos.isEmpty() ? null : tdos.get(0);
		}
		em.close();
		return tdo;
	}

	/**
	 * <b>Persists</b> a <b>new</b> theme to the datadase, <u>if only if</u>
	 * the object is not persisted yet.
	 *
	 * @param theme the theme to be persisted.
	 */
	public void createTheme(ThemeDO themeDO) {
		create(themeDO);
	}

	/**
	 * <b>Merge</b> the theme's state to the database.
	 *
	 * @param theme the theme to have your state updated on the database.
	 */
	public void editTheme(ThemeDO themeDO) {
		merge(themeDO);
	}

	/**
	 * <b>Delete</b> the <u>persisted</u> theme from the database.
	 *
	 * @param theme the theme to be deleted.
	 */
	public void deleteTheme(ThemeDO themeDO) {
		delete(themeDO);
	}

	/**
	 * Lists <b>all</b> the persisted themes.
	 *
	 * @return the <code>List</code> with <b>all</b> persisted themes.
	 */
	@SuppressWarnings("unchecked")
	public List<ThemeDO> listThemes() {
		return list("ThemeDO");
	}

}
