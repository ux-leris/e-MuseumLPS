package com.lpsmuseum.dto;

import java.util.Calendar;

import com.lpsmuseum.behaviour.object.Indexation;
import com.lpsmuseum.entity.MuseologicalObjectDO;

/**
 * This class represents a generic museological object, just for transfer 
 * between client-side and server-side.
 * 
 * @author USER
 */
public class MuseologicalObject {
	
	/**
	 * A museological object identification.
	 */
	private Long objectId;
	
	/**
	 * A museological object name.
	 */
	private String name;
	
	/**
	 * A museological object type.
	 * 
	 * TODO Why boolean?
	 */
	private Boolean objectType;
	
	/**
	 * A museological object date.
	 * 
	 * The date means when the object is inserted in the database.
	 */
	private Calendar date = Calendar.getInstance();
	
	/**
	 * A museological object indexation estrategy.
	 * 
	 * @see Indexation
	 */
	private Indexation indexation;

	/**
	 * Gets the id registered for this museological object.
	 * 
	 * @return a Long value representing the id registered for this 
	 * museological object.
	 */
	public Long getId() {
		return objectId;
	}

	/**
	 * Registers the id for this museological object.
	 * 
	 * @param objectId a Long value representing the id to be registered for 
	 * this museological object.
	 */
	public void setId(Long objectId) {
		this.objectId = objectId;
	}

	/**
	 * Gets the type registered for this museological object.
     * 
	 * @return a Boolean value representing the type for this museological object.
	 */
	public Boolean getObjectType() {
		return objectType;
	}
	
	/**
	 * Registers the type for this museological object.
	 * 
	 * @param objectType a Boolean value representing the type to be registered 
	 * for this museological object.
	 */
	public void setObjectType(Boolean objectType) {
		this.objectType = objectType;
	}

	/**
	 * Gets the indexation strategy registered for this museological object.
	 * 
	 * @return a object of Indexation representing the strategy of indexation 
	 * for this museological object.
	 * @see Indexation
	 */
	public Indexation getIndexation() {
		return indexation;
	}

	/**
	 * Registers an indexation strategy for this museological object.
	 * 
	 * @param indexation an indexation strategy to be registered for this 
	 * museological object.
	 * @see Indexation
	 */
	public void setIndexation(Indexation indexation) {
		this.indexation = indexation;
	}
	
	/**
	 * Gets the name registered for this museological object.
	 * 
	 * @return a name registered for this this museological object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Registers a name for this museological object.
	 * 
	 * @param name a String representing the name for this museological object.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the date registered for this museological object.
	 * 
	 * @return a date registered fot this museological object.
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * Registers a date for this museological object.
	 * 
	 * @param date a Calendar object representing the date for this museological object.
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * Creates a generic museological object.
	 * 
	 * @param name a String value representing the name for this museological object.
	 * @param date a Calendar object representing the date for this museological object.
	 * @return this muselogical object with given name and date.
	 */
	public MuseologicalObject createObject(String name, Calendar date) {
		this.name = name;
		this.date = date;
		return this;
	}
	
	/**
	 * Gets the entity representation for this museological object.
	 * 
	 * @return a MuseologicalObjectDO object representing this museological object.
	 * @see MuseologicalObjectDO
	 *//*
	public MuseologicalObjectDO getEntity(){
		MuseologicalObjectDO objDO = new MuseologicalObjectDO();
		if(objectId != null) objDO.setId(objectId);
		objDO.setName(name);
		objDO.setDate(date.getTime());
		objDO.setObjectType(objectType);
		return objDO;
	}*/
}
