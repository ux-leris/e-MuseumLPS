/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.entity;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.object.Text;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Luis Eduardo
 */
@Entity
@SuppressWarnings("serial")
public class TextDO extends MuseologicalObjectDO {
    @Column(name="text")
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

	@Override
	public MuseologicalObject getDto() {
		Text text = new Text();
		text.setId(getId());
		text.setName(getName());
		Calendar c = Calendar.getInstance();
		c.setTime(getDate());
		text.setDate(c);
		text.setObjectType(getObjectType());
		text.setText(this.text);
		return text;
	}
	
	
}
