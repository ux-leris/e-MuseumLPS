package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.entity.ThemeDO;

/**
 * This class represents a <b>theme</b>, just for transfer between client-side 
 * and server-side.
 */
public class Theme {
	
	/**
	 * This field represents the theme's id.
	 */
	private Long id;
	
	/**
	 * This field represents the theme's title;
	 */
	private String title;
	
	/**
	 * This fields represents the theme's description.
	 */
	private String description;

	/**
	 * Class constructor.
	 */
	public Theme() {
	}

	/**
	 * Returns the <code>id</code> of this <code>Theme</code> instance.
	 *
	 * @return the <code>id</code> of this <code>Theme</code> instance.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the <code>id</code> of this <code>Theme</code> instance.
	 *
	 * @param id the <code>id</code> of this <code>Theme</code> instance.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the <code>title</code> of this <code>Theme</code> instance.
	 *
	 * @return the <code>title</code> of this <code>Theme</code> instance.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the <code>title</code> of this <code>Theme</code> instance.
	 *
	 * @param title the <code>title</code> of this <code>Theme</code> 
	 * instance.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Returns the <code>description</code> of this <code>Theme</code> instance.
	 * 
	 * @return the <code>description</code> of this <code>Theme</code> instance.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the <code>description</code> of this <code>Theme</code> instance.
	 * 
	 * @param description  the <code>description</code> of this <code>Theme
	 * </code> instance.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Returns the entity representation (<code>ThemeDO</code>) for this 
	 * <code>Theme</code> instance.
	 * 
	 * @return the entity representation (<code>ThemeDO</code>) for this 
	 * <code>Theme</code> instance.
	 * @see ThemeDO
	 */
	public ThemeDO getEntity() {
		ThemeDO tdo = new ThemeDO();
		
		tdo.setId(id);
		tdo.setTitle(title);
		tdo.setDescription(description);
		
		return tdo;
	}
}
