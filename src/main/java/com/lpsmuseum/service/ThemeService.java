package com.lpsmuseum.service;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dao.ThemeDAO;
import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.entity.ThemeDO;

/**
 * This class provides services to work with <b>themes</b>.
 *
 * <p>
 * The services available are only list and search.
 *
 * @see Theme
 */
public class ThemeService {

	/**
	 * This fields provides communication with the database.
	 */
	private final ThemeDAO dao = new ThemeDAO();

	/**
	 * Class constructor.
	 */
	public ThemeService() {
	}

	/**
	 * Searchs for the theme with given <code>id</code>.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Long id = 1L;
	 * ThemeService service = new ThemeService();
	 * Theme theme = service.findById(id);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param id the id of the theme.
	 * @return the <code>Theme</code> instance representing a register in the 
	 * database with given <code>id</code>. If the register can't be found, 
	 * <code>null</code> is returned.
	 */
	public Theme findById(Long id) {
		Theme t = new Theme();
		
		t.setId(id);
		ThemeDO tdo = t.getEntity();
		
		return tdo.getDto();
	}

	/**
	 * Lists all the themes.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * ThemeService service = new ThemeService();
	 * List&lt;Theme&gt; themes = service.listTheme();
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @return the <code>List</code> of all <code>Theme</code> stored in the 
	 * database.
	 */
	public List<Theme> listThemes() {
		List<ThemeDO> tdos = dao.listThemes();
		ArrayList<Theme> themes = new ArrayList<Theme>();
		for (ThemeDO tdo : tdos) {
			themes.add(tdo.getDto());
		}
		return themes;
	}
}
