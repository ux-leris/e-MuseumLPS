package com.lpsmuseum.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.lpsmuseum.entity.ThemeDO;

public class ThemeDAO extends BasicDAO {
	
	public void createTheme(ThemeDO themeDO) {
		create(themeDO);
	}

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
	
	public void editTheme(ThemeDO themeDO) {
		merge(themeDO);
	}
	
	@SuppressWarnings("unchecked")
	public List<ThemeDO> listThemes() {
		return list("ThemeDO");
	}
	
	public void deleteTheme(ThemeDO themeDO) {
		delete(themeDO);
	}

}
