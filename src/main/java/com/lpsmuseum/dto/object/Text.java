package com.lpsmuseum.dto.object;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.entity.TextDO;

/**
 * This class represents a <u>specialization</u> of <code>MuseologicalObject
 * </code>, just for transfer between client-side and server-side.
 */
public class Text extends MuseologicalObject {

	/**
	 * This field represents the text's content.
	 */
	private String text;

	/**
	 * Returns the content of this <code>Text</code> instance.
	 * 
	 * @return the content of this <code>Text</code> instance.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the content of this <code>Text</code> instance.
	 * 
	 * @param text the content of this <code>Text</code> instance.
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public TextDO getEntity() {
		TextDO objDO = new TextDO();
		
		if(getId() != null) objDO.setId(getId());
		objDO.setName(getName());
		objDO.setDate(getDate().getTime());
		objDO.setObjectType(getObjectType());
		objDO.setText(text);
		
		return objDO;
	}

}
