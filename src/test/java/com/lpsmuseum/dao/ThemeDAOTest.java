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
        for (int i = 0; i < themes.size(); i++) {
            Theme theme = themes.get(i);
            theme = ((ThemeDO) dao.findEntity(theme.getEntity())).getDto();
            assertNotNull(theme);
            themes.get(i).setId(theme.getId());
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
        for (int i = 0; i < themes.size(); i++) {
            Theme theme = themes.get(i);
            for (ThemeDO themeDO : themesDO)
                if (theme.getId().equals(themeDO.getId())) {
                    assertNotSame(theme.getTitle(), themeDO.getTitle());
                    theme = themeDO.getDto();
                    break;
                }
            themes.get(i).setTitle(theme.getTitle());
        }

        /*
	 * Deleting
         */
        int expected = themesDO.size() - themes.size();
        for (int i = 0; i < themes.size(); i++) {
            Theme theme = themes.get(i);
            for (ThemeDO themeDO : themesDO)
                if (theme.getId().equals(themeDO.getId())) {
                    dao.deleteTheme(themeDO);
                    break;
                }
        }

        themesDO = dao.listThemes();
        assertNotNull(themesDO);
        assertEquals(expected, themesDO.size());
    }

}
