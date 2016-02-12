package com.lpsmuseum.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * This <code>abstract class</code> is based in the <b>Data Access Object 
 * pattern (DAO)</b>, made under Hibernate implementation of <b>Java 
 * Persistence API (JPA)</b>.
 * <p>
 * All the <b>CRUD (Create, Retrieve, Update and Delete)</b> operations are 
 * supported.
 */
public abstract class BasicDAO {

	/**
	 * <b>Persists</b> a <b>new</b> object to the datadase, <u>if only if</u> 
	 * the object is not persisted yet.
	 * 
	 * @param obj the object to be persisted.
	 */
	protected void create(Object obj){
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		if(findEntity(obj) == null) em.persist(obj);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * <b>Merge</b> the object's state to the database.
	 * 
	 * @param obj the object to have your state updated on the database.
	 */
	protected void merge(Object obj){
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(obj);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * <b>Delete</b> the <u>persisted</u> object from the database.
	 * 
	 * @param obj the object to be deleted.
	 */
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
	
	/**
	 * <b>Delete</b> the <u>persisted</u> object from the database.
	 * <p>
	 * The <u>persisted</u> object is of type of given <code>Class</code>, 
	 * identified by a <b>unique</b> <code>id</code> field.
	 * 
	 * @param c the type of the <u>persisted</u> object.
	 * @param id the <b>unique</b> <code>id</code> for the object.
	 */
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
	
	/**
	 * Search the <u>entity</u> object for the given <code>object</code>.
	 * 
	 * @param obj the object to search for.
	 * @return the <u>entity</u> representation of object searched.
	 */
	public abstract Object findEntity(Object obj);
	
	/**
	 * Lists <b>all</b> the persisted objects of given <u>type</u>.
	 * <p>
	 * Usually, the <code>type</code> is an entity class name, e.g.:
	 * <ul>
	 * <li>AnnotationDO
	 * <li>MuseologicalObjectDO
	 * <li>MuseumDO
	 * <li>ScenarioDO
	 * <li>ChallengeDO
	 * </ul>
	 * 
	 * @param type the type of the persisted objects.
	 * @return the <code>List</code> with <b>all</b> persisted objects of given 
	 * <u>type</u>.
	 */
	@SuppressWarnings("rawtypes")
	protected List list(String type){
		return list(type, null);
	}
	
	/**
	 * Lists <b>all</b> the persisted objects of given <u>type</u> who satisfy 
	 * the <code>where</code> condition.
	 * <p>
	 * Usually, the <code>type</code> is an entity class name, e.g.:
	 * <ul>
	 * <li>AnnotationDO
	 * <li>MuseologicalObjectDO
	 * <li>MuseumDO
	 * <li>ScenarioDO
	 * <li>ChallengeDO
	 * </ul>
	 * 
	 * @param type the type of the persisted objects.
	 * @param where the condition to select the persisted objects.
	 * @return the <code>List</code> with <b>all</b> persisted objects of given 
	 * <u>type</u> who satisfy the <code>where</code> condition.
	 */
	@SuppressWarnings("rawtypes")
	protected List list(String type, String where){
		EntityManager em = PersistenceUtil.getEntityManager();
		String sql;
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
