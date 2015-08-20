package com.lpsmuseum.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.lpsmuseum.entity.MuseumDO;

public class MuseumDAO extends BasicDAO {

	public void createMuseum(MuseumDO museum) {
		create(museum);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object findEntity(Object obj) {
		MuseumDO mdo = (MuseumDO)obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if(mdo.getId() != null){
			mdo =  em.find(mdo.getClass(), mdo.getId());
		}
		else{
			List<MuseumDO> mdos = (List<MuseumDO>)em.createQuery("SELECT m FROM MuseumDO m WHERE m.name = '" + mdo.getName()  + "'")
				.getResultList();
			mdo = mdos.isEmpty() ? null : mdos.get(0);
		}
		em.close();
		return mdo;
	}
	
	public void editMuseum(MuseumDO museumDO){
		merge(museumDO);
	}

	@SuppressWarnings("unchecked")
	public List<MuseumDO> listMuseums(){
		return list("MuseumDO");
	}

	public void deleteMuseum(MuseumDO museum) {
		delete(museum);		
	}
}
