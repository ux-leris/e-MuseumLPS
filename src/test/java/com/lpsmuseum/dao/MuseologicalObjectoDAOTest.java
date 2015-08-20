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
		for (MuseologicalObject object : objects) {
			boolean match = false;
			for (MuseologicalObjectDO objectDO : objectsDO) {
				if (object.getEntity().getId() == objectDO.getId()) {
					match = true;
					break;
				}
			}
			assertTrue(match);
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
		for (MuseologicalObject object : objects) {
			boolean match = false;
			for (MuseologicalObjectDO objectDO : objectsDO) {
				if (object.getEntity().getId() == objectDO.getId()) {
					match = true;
					break;
				}
			}
			assertTrue(match);
		}
		
		/*
		 * Deleting
		 */
		
		for (MuseologicalObject object : objects) {
			assertNotNull(object);
			MuseologicalObjectDO objectDO = object.getEntity();
			assertNotNull(objectDO);
			dao.deleteObject(objectDO);
		}
		
		objectsDO = dao.listObjects();
		assertNotNull(objectsDO);
		for (MuseologicalObject object : objects) {
			boolean match = false;
			for (MuseologicalObjectDO objectDO : objectsDO) {
				if (object.getEntity().getId() == objectDO.getId()) {
					match = true;
					break;
				}
			}
			assertFalse(match);
		}
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
