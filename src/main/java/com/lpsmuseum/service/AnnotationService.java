package com.lpsmuseum.service;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dao.AnnotationDAO;
import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.entity.AnnotationDO;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.MuseumDO;

public class AnnotationService {
	AnnotationDAO dao = new AnnotationDAO();
	
	public void createAnnotation(Annotation annotation){
		AnnotationDO ado = getEntity(annotation);
		dao.createAnnotation(ado);
		annotation.setId(ado.getId());
	}
	
	private AnnotationDO getEntity(Annotation annotation){
		AnnotationDO ado = new AnnotationDO();
		ado.setId(annotation.getId());
		ado.setTitle(annotation.getTitle());
		ado.setAuthor(annotation.getAuthor());
		ado.setContent(annotation.getContent());
		if(annotation.getIdMuseum() != null){
			MuseumDO mdo = new MuseumDO();
			mdo.setId(annotation.getIdMuseum());
			ado.setMuseum(mdo);
		}
		if(annotation.getIdObject() != null){
			MuseologicalObjectDO odo = new MuseologicalObjectDO();
			odo.setId(annotation.getIdObject());
			ado.setObject(odo);
		}
		return ado;
	}
	
	private Annotation getDto(AnnotationDO ado){
		Annotation annotation = new Annotation();
		annotation.setId(ado.getId());
		annotation.setTitle(ado.getTitle());
		annotation.setContent(ado.getContent());
		if(ado.getMuseum() != null)
			annotation.setIdMuseum(ado.getMuseum().getId());
		if(ado.getObject() != null)
			annotation.setIdObject(ado.getObject().getId());
		return annotation;
	}
	
	public Annotation findById(Long id){
		Annotation an = new Annotation();
		an.setId(id);
		return findAnnotation(an);
	}
	
	public Annotation findByTitle(String title){
		Annotation an = new Annotation();
		an.setTitle(title);
		return findAnnotation(an);
	}
	
	private Annotation findAnnotation(Annotation annotation){
		AnnotationDO ado = new AnnotationDO();
		ado.setId(annotation.getId());
		ado.setTitle(annotation.getTitle());
		ado = (AnnotationDO)dao.findEntity(ado);
		return ado == null ? null : getDto(ado);
	}
	
	public ArrayList<Annotation> listByObject(Long objectId){
		List<AnnotationDO> ados = dao.listByObject(objectId);
		return listAnnotation(ados);
	}
	
	public ArrayList<Annotation> listByMuseum(Long museumId){
		List<AnnotationDO> ados = dao.listByMuseum(museumId);
		return listAnnotation(ados);
	}
	
	public ArrayList<Annotation> listAnnotation(){
		List<AnnotationDO> ados = dao.listAnnotations();
		return listAnnotation(ados);
	}
	
	private ArrayList<Annotation> listAnnotation(List<AnnotationDO> ados){
		ArrayList<Annotation> ans = new ArrayList<Annotation>();
		for(AnnotationDO ado : ados){
			ans.add(getDto(ado));
		}
		return ans;
	}

	public void editAnnotation(Annotation annotation){
		AnnotationDO ado = getEntity(annotation);
		dao.editAnnotation(ado);
	}
	
	public void deleteAnnotation(Long id){
		AnnotationDO ado = new AnnotationDO();
		ado.setId(id);
		dao.deleteAnnotation(ado);
	}
}
