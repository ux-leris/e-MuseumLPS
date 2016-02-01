package com.lpsmuseum.dto.object;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.entity.ImageDO;

/**
 * This class represents a <u>specialization</u> of <code>MuseologicalObject
 * </code>, just for transfer between client-side and server-side.
 */
public class Image extends MuseologicalObject {
	
	/**
	 * This field represents the image's url address.
	 */
	private String urlAddress;

	/**
	 * Returns the url address of this <code>Image</code> instance.
	 * 
	 * @return the url address of this <code>Image</code> instance.
	 */
	public String getUrlAddress() {
		return urlAddress;
	}

	/**
	 * Sets the url address of this <code>Image</code> instance.
	 * 
	 * @param urlAddress the url address of this <code>Image</code> instance.
	 */
	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}

	@Override
	public ImageDO getEntity(){
		ImageDO objDO = new ImageDO();
		if(getId() != null) objDO.setId(getId());
		objDO.setName(getName());
		objDO.setDate(getDate().getTime());
		objDO.setObjectType(getObjectType());
		objDO.setUrlAddress(urlAddress);
		return objDO;
	}
}
