package com.lpsmuseum.entity;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Text;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * An entity class for text's table (that is a specialization of <code>
 * Museological Object</code>). This entity add this columns to <code>
 * museological_object</code>:
 * <ul>
 * <li>A text
 * </ul>
 *
 * @serial
 * @see MuseologicalObjectDO
 */
@Entity
public class TextDO extends MuseologicalObjectDO {

	/**
	 * This fields represents the text. The column's name is <code>text</code>.
	 */
	@Column(name = "text")
	String text;

	/**
	 * Class constructor.
	 */
	public TextDO() {
	}

	/**
	 * Returns the text for this object.
	 * 
	 * @return the text for this object.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text for this object.
	 * 
	 * @param text the text for this object.
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public MuseologicalObject getDto() {
		Text t = new Text();
		
		t.setId(getId());
		t.setName(getName());
		Calendar c = Calendar.getInstance();
		c.setTime(getDate());
		t.setDate(c);
		t.setObjectType(getObjectType());
		t.setText(text);
		
		return t;
	}

}
