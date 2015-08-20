package com.lpsmuseum.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.lpsmuseum.entity.AnnotationDO;
import com.lpsmuseum.entity.MuseologicalObjectDO;

public class AnnotationDAO extends BasicDAO {

	@Override
	@SuppressWarnings("unchecked")
	public Object findEntity(Object obj) {
		AnnotationDO ado = (AnnotationDO) obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if(ado.getId() != null){
			Object xdo = em.find(MuseologicalObjectDO.class, ado.getId());
			return xdo;
		} else{
			List<AnnotationDO> ados = (List<AnnotationDO>)em.createQuery("SELECT a FROM AnnotationDO a WHERE a.title = '" + ado.getTitle()  + "'")
				.getResultList();
			ado = ados.isEmpty() ? null : ados.get(0);
		}
		em.close();
		return ado;
	}
	//TODO: Refactor findEntity method

	public void createAnnotation(AnnotationDO annotation){
		create(annotation);
	}
	
	public void editAnnotation(AnnotationDO annotation){
		merge(annotation);
	}
	
	@SuppressWarnings("unchecked")
	public List<AnnotationDO> listAnnotations(){
		return list("AnnotationDO");
	}
	
	@SuppressWarnings("unchecked")
	public List<AnnotationDO> listByObject(Long id){
		
		return list("AnnotationDO", "o.object.id = " + id);
	}

	@SuppressWarnings("unchecked")
	public List<AnnotationDO> listByMuseum(Long id){
		return list("AnnotationDO", "o.museum.id = " + id);
	}
	public void deleteAnnotation(AnnotationDO annotation) {
		delete(annotation);		
	}
}
