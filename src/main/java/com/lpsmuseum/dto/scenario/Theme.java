package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.entity.ThemeDO;

public class Theme {
	private Long id;
	private String title;
	private String description;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ThemeDO getEntity() {
		ThemeDO tdo = new ThemeDO();
		tdo.setId(id);
		tdo.setTitle(title);
		tdo.setDescription(description);
		return tdo;
	}
}
