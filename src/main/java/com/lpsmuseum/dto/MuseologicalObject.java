package com.lpsmuseum.dto;

import java.util.Calendar;

import com.lpsmuseum.behaviour.object.Indexation;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.object.Text;
import com.lpsmuseum.entity.MuseologicalObjectDO;

/**
 * This class represents a <u>generic</u> <b>museological object</b>, just for 
 * transfer between client-side and server-side.
 * <p>
 * This can be <b>specialized</b> to represent <code>Image</code> or <code>Text
 * </code>.
 * @see Image
 * @see Text
 */
public class MuseologicalObject {
	
	/**
	 * This field represents the museological object's id.
	 */
	private Long objectId;
	
	/**
	 * This field represents the museological object's name.
	 */
	private String name;
	
	/**
	 * This field represents the museological object's type.
	 * <p>
	 * Not has a consensus what stands for this <code>boolean</code> field.
	 */
	private Boolean objectType;
	
	/**
	 * This fields represents the museological object's date;
	 * <p>
	 * The date means when the object is inserted in the database.
	 */
	private Calendar date = Calendar.getInstance();
	
	/**
	 * This fields represents the museological object's indexation.
	 * 
	 * @see Indexation
	 */
	private Indexation indexation;

	/**
	 * Class constructor.
	 */
	public MuseologicalObject() {
	}

	/**
	 * Returns the <code>id</code> of this <code>MuseologicalObject</code> 
	 * instance.
	 *
	 * @return the <code>id</code> of this <code>MuseologicalObject</code> 
	 * instance.
	 */
	public Long getId() {
		return objectId;
	}

	/**
	 * Sets the <code>id</code> of this <code>MuseologicalObject</code> 
	 * instance.
	 *
	 * @param objectId the <code>id</code> of this <code>MuseologicalObject
	 * </code> instance.
	 */
	public void setId(Long objectId) {
		this.objectId = objectId;
	}

	/**
	 * Returns the <code>name</code> of this <code>MuseologicalObject</code> 
	 * instance.
	 *
	 * @return the <code>name</code> of this <code>MuseologicalObject</code> 
	 * instance.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the <code>name</code> of this <code>MuseologicalObject</code> 
	 * instance.
	 *
	 * @param name the <code>name</code> of this <code>MuseologicalObject
	 * </code> instance.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the type of this <code>MuseologicalObject</code> instance.
	 *
	 * @return the type of this <code>MuseologicalObject</code> instance.
	 */
	public Boolean getObjectType() {
		return objectType;
	}

	/**
	 * Sets the type of this <code>MuseologicalObject</code> instance.
	 *
	 * @param objectType the type of this <code>MuseologicalObject</code> 
	 * instance.
	 */
	public void setObjectType(Boolean objectType) {
		this.objectType = objectType;
	}

	/**
	 * Returns a <code>Calendar</code> object for the date of this <code>
	 * MuseologicalObject</code> instance.
	 *
	 * @return the <code>date</code> of this <code>MuseologicalObject</code> 
	 * instance.
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * Sets a <code>Calendar</code> object for the date of this <code>
	 * MuseologicalObject</code> instance.
	 *
	 * @param date the <code>date</code> of this <code>MuseologicalObject
	 * </code> instance.
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * Returns the indexation strategy of this <code>MuseologicalObject</code> 
	 * instance.
	 * 
	 * @return the indexation strategy of this <code>MuseologicalObject</code> 
	 * instance.
	 * @see Indexation
	 */
	public Indexation getIndexation() {
		return indexation;
	}

	/**
	 * Sets the indexation strategy of this <code>MuseologicalObject</code> 
	 * instance.
	 * 
	 * @param indexation the indexation strategy of this <code>
	 * MuseologicalObject</code> instance.
	 * @see Indexation
	 */
	public void setIndexation(Indexation indexation) {
		this.indexation = indexation;
	}

	/**
	 * Creates a generic <code>MuseologicalObject</code> object.
	 * 
	 * @param name a String value representing the name.
	 * @param date a Calendar object representing the date.
	 * @return this museological object with given name and date.
	 */
	public MuseologicalObject createObject(String name, Calendar date) {
		this.name = name;
		this.date = date;
		return this;
	}
	
	/**
	 * Returns the entity representation (<code>MuseologicalObjectDO</code>) 
	 * for this <code>MuseologicalObject</code> instance.
	 * 
	 * @return the entity representation (<code>MuseologicalObjectDO</code>) 
	 * for this <code>MuseologicalObject</code> instance.
	 * @see MuseologicalObjectDO
	 */
	public MuseologicalObjectDO getEntity(){
		MuseologicalObjectDO objDO = new MuseologicalObjectDO();
		if(objectId != null) objDO.setId(objectId);
		objDO.setName(name);
		objDO.setDate(date.getTime());
		objDO.setObjectType(objectType);
		return objDO;
	}
}
