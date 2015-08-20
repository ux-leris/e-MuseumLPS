package com.lpsmuseum.dto;

import java.util.Calendar;

import com.lpsmuseum.behaviour.object.Indexation;
import com.lpsmuseum.entity.MuseologicalObjectDO;

public class MuseologicalObject {
	private Long objectId;
	private String name;
	private Boolean objectType;
	private Calendar date = Calendar.getInstance();
	private Indexation indexation;

	public Long getId() {
		return objectId;
	}

	public void setId(Long objectId) {
		this.objectId = objectId;
	}

	public Boolean getObjectType() {
		return objectType;
	}

	public void setObjectType(Boolean objectType) {
		this.objectType = objectType;
	}

	public Indexation getIndexation() {
		return indexation;
	}

	public void setIndexation(Indexation indexation) {
		this.indexation = indexation;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public MuseologicalObject createObject(String name, Calendar date) {
		this.name = name;
		this.date = date;
		return this;
	}
	
	public MuseologicalObjectDO getEntity(){
		MuseologicalObjectDO objDO = new MuseologicalObjectDO();
		if(objectId != null) objDO.setId(objectId);
		objDO.setName(name);
		objDO.setDate(date.getTime());
		objDO.setObjectType(objectType);
		return objDO;
	}
}
