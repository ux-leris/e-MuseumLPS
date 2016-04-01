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
        for (int i = 0; i < museums.size(); i++) {
            Museum museum = museums.get(i);
            museum = ((MuseumDO) dao.findEntity(museum.getEntity())).getDto();
            assertNotNull(museum);
            museums.get(i).setId(museum.getId());
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
        for (int i = 0; i < museums.size(); i++) {
            Museum museum = museums.get(i);
            for (MuseumDO museumDO : museumsDO)
                if (museum.getId().equals(museumDO.getId())) {
                    assertNotSame(museum.getName(), museumDO.getName());
                    museum = museumDO.getDto();
                    break;
                }
            museums.get(i).setName(museum.getName());
        }

        /*
	 * Deleting
         */
        int expected = museumsDO.size() - museums.size();
        for (int i = 0; i < museums.size(); i++) {
            Museum museum = museums.get(i);
            for (MuseumDO museumDO : museumsDO)
                if (museum.getId().equals(museumDO.getId())) {
                    //dao.deleteMuseum(museumDO);
                    break;
                }
        }

        museumsDO = dao.listMuseums();
        assertNotNull(museumsDO);
        //assertEquals(expected, museumsDO.size());
    }

}
