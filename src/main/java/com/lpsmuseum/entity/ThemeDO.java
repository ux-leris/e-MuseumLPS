package com.lpsmuseum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lpsmuseum.dto.scenario.Theme;

@Entity
@Table(name="theme")
@SuppressWarnings("serial")
public class ThemeDO implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_theme")
	private Long id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public Theme getDto() {
		Theme dto = new Theme();
		dto.setDescription(description);
		dto.setId(id);
		dto.setTitle(title);
		return dto;
	}
}
