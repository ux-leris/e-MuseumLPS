package com.lpsmuseum.service;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dao.MuseologicalObjectDAO;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.entity.ImageDO;
import com.lpsmuseum.entity.MuseologicalObjectDO;

public class MuseologicalObjectService {
	MuseologicalObjectDAO dao = new MuseologicalObjectDAO();
	
	public void createObject(MuseologicalObject object){
		/*MuseologicalObjectDO objDO = object.getEntity();
		dao.createObject(objDO);
		object.setId(objDO.getId());*/
	}
	
	public MuseologicalObject findById(Long id) {
		MuseologicalObject mo = new MuseologicalObject();
		mo.setId(id);
		MuseologicalObjectDO modo = findEntity(mo);
		return modo.getDto();
	}
	
	public void editObject(MuseologicalObject object){
		/*MuseologicalObjectDO objDO = object.getEntity();
		dao.editObject(objDO);*/
	}
	
	public MuseologicalObject findObject(MuseologicalObject object){
		MuseologicalObjectDO mdo = findEntity(object);
		return mdo.getDto();
	}

	public MuseologicalObjectDO findEntity(MuseologicalObject object) {
		MuseologicalObjectDO objDO = new MuseologicalObjectDO();
		objDO.setId(object.getId());
		objDO.setName(object.getName());
		return objDO;//(MuseologicalObjectDO)dao.findEntity(objDO);
	}
	
	public ArrayList<MuseologicalObject> listObjects(){
		List<MuseologicalObjectDO> odos = dao.listObjects();
		ArrayList<MuseologicalObject> objects = new ArrayList<MuseologicalObject>();
		for(MuseologicalObjectDO odo : odos){
			MuseologicalObject o = odo.getDto();
			objects.add(o);
		}
		return objects;
	}
	
	public void deleteObject(Long id){
		MuseologicalObjectDO obj = new MuseologicalObjectDO();
		obj.setId(id);
		
		if (dao.findEntity(obj) instanceof ImageDO) {
			obj = new ImageDO();
			obj.setId(id);
		}
		
		dao.deleteObject(obj);
	}
}
