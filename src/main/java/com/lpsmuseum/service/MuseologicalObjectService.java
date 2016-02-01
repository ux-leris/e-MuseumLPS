package com.lpsmuseum.service;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dao.MuseologicalObjectDAO;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.entity.ImageDO;
import com.lpsmuseum.entity.MuseologicalObjectDO;

/**
 * This class provides services to work with <b>museological objets</b>.
 *
 * <p>
 * The services available are all the CRUD operations.
 *
 * @see MuseologicalObject
 */
public class MuseologicalObjectService {

	/**
	 * This fields provides communication with the database.
	 */
	private final MuseologicalObjectDAO dao = new MuseologicalObjectDAO();

	/**
	 * Class constructor.
	 */
	public MuseologicalObjectService() {
	}

	/**
	 * Creates a new register in the database for a
	 * <code>MuseologicalObject</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * MuseologicalObject museologicalObject = new MuseologicalObject();
	 * // Getters call on museologicalObject
	 * MuseologicalObjectService service = new MuseologicalObjectService();
	 * service.createObject(museologicalObject);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param object the <code>MuseologicalObject</code> instance to be
	 * registered in the database.
	 */
	public void createObject(MuseologicalObject object) {
		MuseologicalObjectDO objDO = object.getEntity();
		dao.createObject(objDO);
		object.setId(objDO.getId());
	}

	/**
	 * Searchs for the museological object with given <code>id</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Long id = 1L;
	 * MuseologicalObjectService service = new MuseologicalObjectService();
	 * MuseologicalObject museologicalObject = service.findById(id);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param id the id of the museological object.
	 * @return the <code>MuseologicalObject</code> instance representing a
	 * register in the database with given <code>id</code>. If the register
	 * can't be found, <code>null</code> is returned.
	 */
	public MuseologicalObject findById(Long id) {
		MuseologicalObject mo = new MuseologicalObject();
		mo.setId(id);
		MuseologicalObjectDO modo = findEntity(mo);
		return modo.getDto();
	}

	/**
	 * Updates an <code>Annotation</code> stored in the database.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * MuseologicalObjectService service = new MuseologicalObjectService();
	 * MuseologicalObject object = service.findById(1L);
	 * object.setName("New Museological Object");
	 * service.editMuseologicalObject(object);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param object the <code>MuseologicalObject</code> to be updated.
	 */
	public void editObject(MuseologicalObject object) {
		dao.editObject(object.getEntity());
	}

	/**
	 * Searchs for the register corresponding with given <code>object</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * MuseologicalObject object = new MuseologicalObject().
	 * object.setId(1L);
	 * MuseologicalObjectService service = new MuseologicalObjectService();
	 * object = service.findObject(object);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param object the museological object to be searched in the database.
	 * @return the <code>MuseologicalObject</code> instance representing a
	 * register in the database. If the register can't be found,
	 * <code>null</code> is returned.
	 */
	public MuseologicalObject findObject(MuseologicalObject object) {
		MuseologicalObjectDO mdo = findEntity(object);
		return mdo.getDto();
	}

	/**
	 * Finds the entity corresponding to given <code>MuseologicalObject</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * MuseologicalObject object = new MuseologicalObject();
	 * object.setId(1L);
	 * MuseologicalObjectService service = new MuseologicalObjectService();
	 * MuseologicalObjectDO objectDO = service.findEntity(object);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param object the museological object to be searched.
	 * @return the entity instance of given <code>MuseologicalObject</code>.
	 */
	public MuseologicalObjectDO findEntity(MuseologicalObject object) {
		return (MuseologicalObjectDO) dao.findEntity(object.getEntity());
	}

	/**
	 * Lists all the museological objects.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * MuseologicalObjectService service = new MuseologicalObjectService();
	 * List&lt;MuseologicalObject&gt; objects = service.listObjects();
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @return the <code>List</code> of all <code>MuseologicalObject</code>
	 * stored in the database.
	 */
	public List<MuseologicalObject> listObjects() {
		List<MuseologicalObjectDO> odos = dao.listObjects();
		List<MuseologicalObject> objects = new ArrayList<MuseologicalObject>();
		for (MuseologicalObjectDO odo : odos) {
			MuseologicalObject o = odo.getDto();
			objects.add(o);
		}
		return objects;
	}

	/**
	 * Deletes an <code>MuseologicalObject</code> stored in the database.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * MuseologicalObjectService service = new MuseologicalObjectService();
	 * MuseologicalObject object = service.findById(1L);
	 * service.deleteObject(object.getId());
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param id the <code>id</code> of <code>MuseologicalObject</code> to be
	 * deleted.
	 */
	public void deleteObject(Long id) {
		MuseologicalObjectDO obj = new MuseologicalObjectDO();

		obj.setId(id);

		if (dao.findEntity(obj) instanceof ImageDO) {
			obj = new ImageDO();
			obj.setId(id);
		}

		dao.deleteObject(obj);
	}
}
