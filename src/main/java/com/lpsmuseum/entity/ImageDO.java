package com.lpsmuseum.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Image;

/**
 * An entity class for image's table (that is a specialization of <code>
 * Museological Object</code>). This entity add this columns to <code>
 * museological_object</code>:
 * <ul>
 * <li>An url address to the image's file
 * </ul>
 *
 * @serial
 * @see MuseologicalObjectDO
 */
@Entity
@DiscriminatorValue(value = "ImageDO")
@SuppressWarnings("serial")
public class ImageDO extends MuseologicalObjectDO {

	/**
	 * This fields represents the url address to the image's file. The column's 
	 * name is <code>urlAddress</code>.
	 */
	@Column(name = "urlAddress")
	String urlAddress;

	/**
	 * Class constructor.
	 */
	public ImageDO() {
	}

	/**
	 * Returns the url address to the image's file.
	 * 
	 * @return the url address to the image's file.
	 */
	public String getUrlAddress() {
		return urlAddress;
	}

	/**
	 * Sets the url address to the image's file.
	 * 
	 * @param urlAddress the url address to the image's file.
	 */
	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}

	@Override
	public MuseologicalObject getDto() {
		Image image = new Image();
		
		image.setId(getId());
		image.setName(getName());
		Calendar c = Calendar.getInstance();
		c.setTime(getDate());
		image.setDate(c);
		image.setObjectType(getObjectType());
		image.setUrlAddress(getUrlAddress());
		
		return image;
	}
}
