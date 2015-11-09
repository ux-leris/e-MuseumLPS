package com.lpsmuseum.dto.object;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.TextDO;

public class Text extends MuseologicalObject {

	String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/*@Override
	public MuseologicalObjectDO getEntity() {
		TextDO objDO = new TextDO();
		if(getId() != null) objDO.setId(getId());
		objDO.setName(getName());
		objDO.setDate(getDate().getTime());
		objDO.setObjectType(getObjectType());
		objDO.setText(text);
		return objDO;
	}*/

}
