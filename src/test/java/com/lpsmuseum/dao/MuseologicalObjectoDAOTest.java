package com.lpsmuseum.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.entity.ImageDO;
import com.lpsmuseum.entity.MuseologicalObjectDO;

public class MuseologicalObjectoDAOTest extends TestCase {

    List<MuseologicalObject> objects;

    public MuseologicalObjectoDAOTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(MuseologicalObjectoDAOTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        // MuseologicalObject
        objects = DAOTestUtil.generateMuseologicalObjects();
    }

    public void testCRUD() {
        assertNotNull(objects);

        MuseologicalObjectDAO dao = new MuseologicalObjectDAO();
        assertNotNull(dao);

        List<MuseologicalObjectDO> objectsDO;

        /*
	 * Creating
         */
        // Are the objects persisting?
        for (MuseologicalObject object : objects) {
            assertNotNull(object);
            MuseologicalObjectDO objectDO = object.getEntity();
            assertNotNull(objectDO);
            dao.createObject(objectDO);
        }

        // Are the objects persisted?
        objectsDO = dao.listObjects();
        assertNotNull(objectsDO);
        for (int i = 0; i < objects.size(); i++) {
            MuseologicalObject object = objects.get(i);
            object = ((MuseologicalObjectDO) dao.findEntity(object.getEntity())).getDto();
            assertNotNull(object);
            objects.get(i).setId(object.getId());
        }

        /*
	 * Editing
         */
        // Can objects be modified and persisted?
        for (MuseologicalObject object : objects) {
            assertNotNull(object);
            object.setName(object.getName().concat("test"));
            MuseologicalObjectDO objectDO = object.getEntity();
            assertNotNull(objectDO);
            dao.editObject(objectDO);
        }

        // Are the objects modified and persisting?
        objectsDO = dao.listObjects();
        assertNotNull(objectsDO);
        for (int i = 0; i < objects.size(); i++) {
            MuseologicalObject object = objects.get(i);
            for (MuseologicalObjectDO objectDO : objectsDO)
                if (object.getId().equals(objectDO.getId())) {
                    assertNotSame(object.getName(), objectDO.getName());
                    object = objectDO.getDto();
                    break;
                }
            objects.get(i).setName(object.getName());
        }

        /*
	 * Deleting
         */
        int expected = objectsDO.size() - objects.size();
        for (int i = 0; i < objects.size(); i++) {
            MuseologicalObject theme = objects.get(i);
            for (MuseologicalObjectDO objectDO : objectsDO)
                if (theme.getId().equals(objectDO.getId())) {
                    dao.deleteObject(objectDO);
                    break;
                }
        }

        objectsDO = dao.listObjects();
        assertNotNull(objectsDO);
        assertEquals(expected, objectsDO.size());
    }

    public void adadd() {
        // Are the objects persisted?
        List<MuseologicalObjectDO> objectsDO = new MuseologicalObjectDAO().listObjects();
        assertNotNull(objectsDO);
        for (MuseologicalObjectDO modo : objectsDO) {
            System.out.println(modo.getClass().getName());
        }

        System.out.println("a");
        objectsDO = new ArrayList<MuseologicalObjectDO>();
        objectsDO.add(new ImageDO());
        objectsDO.add(new MuseologicalObjectDO());
        for (MuseologicalObjectDO modo : objectsDO) {
            System.out.println(modo.getClass().getName());
        }
    }
}
