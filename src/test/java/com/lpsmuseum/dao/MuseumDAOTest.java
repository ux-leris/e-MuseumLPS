package com.lpsmuseum.dao;

import java.util.List;

import junit.framework.TestCase;

import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.entity.MuseumDO;

public class MuseumDAOTest extends TestCase {
	List<Museum> museums;

	protected void setUp() throws Exception {
		museums = DAOTestUtil.generateMuseuns();
	}

	public void testCRUD() throws Exception {
		assertNotNull(museums);

		MuseumDAO dao = new MuseumDAO();
		assertNotNull(dao);

		//List<ScenarioDO> scenariosDO;

		/*
		 * Creating
		 */

		// Are the scenarios persisting?
		for (Museum museum : museums) {
			assertNotNull(museum);
			MuseumDO museumDO = museum.getEntity();
			assertNotNull(museumDO);
			dao.createMuseum(museumDO);
		}

		// Are the scenarios persisted?
		List<MuseumDO> museumsDO = dao.listMuseums();
		assertNotNull(museumsDO);
		for (Museum museum : museums) {
			boolean match = false;
			for (MuseumDO museumDO : museumsDO) {
				if (museum.getEntity().getId() == museumDO.getId()) {
					match = true;
					break;
				}
			}
			assertTrue(match);
		}

		/*
		 * Editing
		 */

		// Can scenarios be modified and persisted?
		for (Museum museum : museums) {
			assertNotNull(museum);
			museum.setName(museum.getName().concat("test"));
			MuseumDO museumDO = museum.getEntity();
			assertNotNull(museumDO);
			dao.editMuseum(museumDO);
		}

		// Are the scenarios modified and persisting?
		museumsDO = dao.listMuseums();
		assertNotNull(museumsDO);
		for (Museum museum : museums) {
			boolean match = false;
			for (MuseumDO museumDO : museumsDO) {
				if (museum.getEntity().getId() == museumDO.getId()) {
					match = true;
					break;
				}
			}
			assertTrue(match);
		}

		/*
		 * Deleting
		 */

		for (Museum museum : museums) {
			assertNotNull(museum);
			MuseumDO museumDO = museum.getEntity();
			assertNotNull(museumDO);
			dao.deleteMuseum(museumDO);
		}

		museumsDO = dao.listMuseums();
		assertNotNull(museumsDO);
		for (Museum museum : museums) {
			boolean match = false;
			for (MuseumDO museumDO : museumsDO) {
				if (museum.getEntity().getId() == museumDO.getId()) {
					match = true;
					break;
				}
			}
			assertFalse(match);
		}
	}

}
