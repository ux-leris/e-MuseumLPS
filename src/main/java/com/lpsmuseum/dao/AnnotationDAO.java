package com.lpsmuseum.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.lpsmuseum.entity.AnnotationDO;
import com.lpsmuseum.entity.MuseologicalObjectDO;

/**
 * This class provides a easy way to work with persistence of annotations.
 * <p>
 * All the <b>CRUD (Create, Retrieve, Update and Delete)</b> operations are 
 * supported.
 * @see BasicDAO
 */
public class AnnotationDAO extends BasicDAO {

	@Override
	@SuppressWarnings("unchecked")
	public Object findEntity(Object obj) {
		AnnotationDO ado = (AnnotationDO) obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if (ado.getId() != null) {
			Object xdo = em.find(MuseologicalObjectDO.class, ado.getId());
			return xdo;
		} else {
			List<AnnotationDO> ados = (List<AnnotationDO>) em.createQuery(
					"SELECT a "
					+ "FROM AnnotationDO a "
					+ "WHERE a.title = '" + ado.getTitle() + "'"
			).getResultList();
			ado = ados.isEmpty() ? null : ados.get(0);
		}
		em.close();
		return ado;
	}
	//TODO: Refactor findEntity method

	/**
	 * <b>Persists</b> a <b>new</b> annotation to the datadase, <u>if only
	 * if</u> the object is not persisted yet.
	 *
	 * @param annotation the annotation to be persisted.
	 */
	public void createAnnotation(AnnotationDO annotation) {
		create(annotation);
	}

	/**
	 * <b>Merge</b> the annotation's state to the database.
	 *
	 * @param annotation the annotation to have your state updated on the
	 * database.
	 */
	public void editAnnotation(AnnotationDO annotation) {
		merge(annotation);
	}

	/**
	 * <b>Delete</b> the <u>persisted</u> annotation from the database.
	 *
	 * @param obj the annotation to be deleted.
	 */
	public void deleteAnnotation(AnnotationDO annotation) {
		delete(annotation);
	}

	/**
	 * Lists <b>all</b> the persisted annotations.
	 *
	 * @return the <code>List</code> with <b>all</b> persisted annotations.
	 */
	@SuppressWarnings("unchecked")
	public List<AnnotationDO> listAnnotations() {
		return list("AnnotationDO");
	}

	/**
	 * Lists <b>all</b> the persisted annotations related with a museological
	 * object with given <code>id</code>.
	 *
	 * @param id the <code>id</code> of a museological object.
	 * @return the <code>List</code> with <b>all</b> persisted annotations
	 * related with a museological object with given <code>id</code>.
	 */
	@SuppressWarnings("unchecked")
	public List<AnnotationDO> listByObject(Long id) {
		return list("AnnotationDO", "o.object.id = " + id);
	}

	/**
	 * Lists <b>all</b> the persisted annotations related with a museum with
	 * given <code>id</code>.
	 *
	 * @param id the <code>id</code> of a museum.
	 * @return the <code>List</code> with <b>all</b> persisted annotations
	 * related with a museum with given <code>id</code>.
	 */
	@SuppressWarnings("unchecked")
	public List<AnnotationDO> listByMuseum(Long id) {
		return list("AnnotationDO", "o.museum.id = " + id);
	}
}
