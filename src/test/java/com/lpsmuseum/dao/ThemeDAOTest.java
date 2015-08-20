package com.lpsmuseum.dao;

import java.util.List;

import junit.framework.TestCase;

import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.entity.ThemeDO;

public class ThemeDAOTest extends TestCase {
	List<Theme> themes;

	protected void setUp() throws Exception {
		themes = DAOTestUtil.generateThemes();
	}

	public void testCRUD() {
		assertNotNull(themes);
		
		ThemeDAO dao = new ThemeDAO();
		assertNotNull(dao);
		
		List<ThemeDO> themesDO;
		
		/*
		 * Creating
		 */
		
		// Are the objects persisting?
		for (Theme theme : themes) {
			assertNotNull(theme);
			ThemeDO themeDO = theme.getEntity();
			assertNotNull(themeDO);
			dao.createTheme(themeDO);
		}
		
		// Are the objects persisted?
		themesDO = dao.listThemes();
		assertNotNull(themesDO);
		for (Theme theme : themes) {
			boolean match = false;
			for (ThemeDO themeDO : themesDO) {
				if (theme.getEntity().getTitle() == themeDO.getTitle()) {
					match = true;
					break;
				}	
			}
			assertTrue(match);
			// TODO themesDO possui menos um registro do que a tabela mapeada.
		}
		
		/*
		 * Editing
		 */
		
		// Can objects be modified and persisted?
		for (ThemeDO themeDO : themesDO) {
			themeDO.setTitle(themeDO.getTitle().concat("test"));
			dao.editTheme(themeDO);
		}
		
		// Are the objects modified and persisting?
		themesDO = dao.listThemes();
		assertNotNull(themesDO);
		for (Theme theme : themes) {
			boolean match = false;
			for (ThemeDO themeDO : themesDO) {
				if (theme.getEntity().getTitle() == themeDO.getTitle()) {
					match = true;
					break;
				}
			}
			assertTrue(match);
		}
		
		/*
		 * Deleting
		 */
		
		for (ThemeDO themeDO : themesDO) {
			assertNotNull(themeDO);
			dao.deleteTheme(themeDO);
		}
		
		themesDO = dao.listThemes();
		assertNotNull(themesDO);
		for (Theme theme : themes) {
			boolean match = false;
			for (ThemeDO themeDO : themesDO) {
				if (theme.getEntity().getTitle() == themeDO.getTitle()) {
					match = true;
					break;
				}
			}
			assertFalse(match);
		}
	}

}
