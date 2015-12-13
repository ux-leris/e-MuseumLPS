package com.lpsmuseum.service;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dao.ThemeDAO;
import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.entity.ThemeDO;

public class ThemeService {
	ThemeDAO dao = new ThemeDAO();
	
	public Theme getDto(ThemeDO tdo){
		Theme theme = new Theme();
		theme.setId(tdo.getId());
		theme.setTitle(tdo.getTitle());
		theme.setDescription(tdo.getDescription());
		return theme;
	}
	
	public ThemeDO getEntity(Theme theme){
		ThemeDO tdo = new ThemeDO();
		tdo.setId(theme.getId());
		tdo.setTitle(theme.getTitle());
		tdo.setDescription(theme.getDescription());
		return tdo;
	}

	public ArrayList<Theme> listThemes() {
		List<ThemeDO> tdos = dao.listThemes();
		ArrayList<Theme> themes = new ArrayList<Theme>();
		for (ThemeDO tdo : tdos)
			themes.add(tdo.getDto());
		return themes;
	}

	/*public Theme findById(Long id) {
		Theme t = new Theme();
		t.setId(id);
		ThemeDO tdo = findEntity(t);
		return tdo.getDto();
	}*/

	/*private ThemeDO findEntity(Theme theme) {
		ThemeDO objDO = theme.getEntity();
		return (ThemeDO) dao.findEntity(objDO);
	}*/
}
