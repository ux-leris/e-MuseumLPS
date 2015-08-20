package com.lpsmuseum.dao;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class BasicDAO {

	protected void create(Object obj){
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		if(findEntity(obj) == null) em.persist(obj);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	protected void merge(Object obj){
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		obj = em.merge(obj);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	protected void delete(Object obj){
		EntityManager em = PersistenceUtil.getEntityManager();
		if(obj != null){
			em.getTransaction().begin();
			obj = em.merge(obj);
			em.remove(obj);
			em.flush();
			em.getTransaction().commit();
		}
		em.close();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void delete(Class c, Object id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		if(id != null){
			em.getTransaction().begin();
			em.remove(em.find(c, id));
			em.flush();
			em.getTransaction().commit();
		}
		em.close();
	}
	
	public abstract Object findEntity(Object obj);
	
	@SuppressWarnings("rawtypes")
	protected List list(String type){
		return list(type, null);
	}
	
	@SuppressWarnings("rawtypes")
	protected List list(String type, String where){
		EntityManager em = PersistenceUtil.getEntityManager();
		String sql = null;
		if (where == null)
			sql = "SELECT o FROM " + type + " o";
		else
			sql = "SELECT o FROM " + type + " o where " + where;
		List odos = em.createQuery(sql)
				.getResultList();
		em.close();
		return odos;
	}
}
