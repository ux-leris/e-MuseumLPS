package com.lpsmuseum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lpsmuseum.dto.scenario.Theme;

/**
 * An entity class for theme's table (with name <code>theme</code>). The table 
 * has columns for:
 * <ul>
 * <li>An id
 * <li>A title
 * <li>A description
 * </ul>
 *
 * @serial
 */
@Entity
@Table(name = "theme")
public class ThemeDO implements Serializable {

	/**
	 * This field is the <b>primary key</b> of the table (so can't be null by
	 * default) and is <u>auto generated</u> sequentially. The column's name in
	 * the table is <code>id_theme</code>.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_theme")
	private Long id;

	/**
	 * This field represents the theme's title. The column's name in the table
	 * is <code>title</code>.
	 */
	// FIX Theme's title can be null?
	@Column(name = "title")
	private String title;

	/**
	 * This field represents the theme's description. The column's name in the
	 * table is <code>description</code>.
	 */
	@Column(name = "description")
	private String description;

	/**
	 * Class constructor.
	 */
	public ThemeDO() {
	}

	/**
	 * Returns the id of the theme.
	 *
	 * @return the id of the theme.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id of this theme.
	 *
	 * @param id the id of this theme.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the title of this theme.
	 *
	 * @return the title of this theme.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of this theme.
	 *
	 * @param title the title of this theme.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the description of this theme.
	 *
	 * @return the description of this theme.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of this theme.
	 *
	 * @param description the description of this theme.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the transfer object representing this theme.
	 *
	 * @return the transfer object representing this museum.
	 */
	public Theme getDto() {
		Theme dto = new Theme();

		dto.setDescription(description);
		dto.setId(id);
		dto.setTitle(title);

		return dto;
	}
}
