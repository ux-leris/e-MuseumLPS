package com.lpsmuseum.service;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dao.MuseumDAO;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.entity.MuseumDO;

/**
 * This class provides services to work with <b>museum</b>.
 *
 * <p>
 * The services available are all the CRUD operations.
 *
 * @see Museum
 */
public class MuseumService {

	/**
	 * This fields provides communication with the database.
	 */
	private final MuseumDAO dao = new MuseumDAO();

	/**
	 * Class constructor.
	 */
	public MuseumService() {
	}

	/**
	 * Creates a new register in the database for a <code>Museum</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Museum museum = new Museum();
	 * // Getters call on museum
	 * MuseumService service = new MuseumService();
	 * service.createMuseum(museum);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param annotation the <code>Annotation</code> instance to be registered
	 * in the database.
	 * @throws Exception if <code>Museum.getEntity</code> rises a exception.
	 * @see Museum
	 */
	public void createMuseum(Museum museum) throws Exception {
		MuseumDO mdo = museum.getEntity();

		dao.createMuseum(mdo);

		museum.setId(mdo.getId());
	}

	/**
	 * Updates an <code>Museum</code> stored in the database.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * MuseumService service = new MuseumService();
	 * Museum museum = service.findById(1L);
	 * museum.setName("Updated Museum");
	 * service.editMuseum(museum);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param museum the <code>Museum</code> to be updated.
	 */
	public void editMuseum(Museum museum) throws Exception {
		dao.editMuseum(museum.getEntity());
	}

	/**
	 * Searchs for the museum with given <code>id</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Long id = 1L;
	 * MuseumService service = new MuseumService();
	 * Museum museum = service.findById(id);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param id the id of the museum.
	 * @return the <code>Museum</code> instance representing a register in the
	 * database with given <code>id</code>. If the register can't be found,
	 * <code>null</code> is returned.
	 */
	public Museum findById(Long id) {
		Museum m = new Museum();
		m.setId(id);
		return findMuseum(m);
	}

	/**
	 * Searchs for the museum with given <code>name</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * String name = "Computers";
	 * MuseumService service = new MuseumService();
	 * Museum museum = service.findByName(name);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param name the name of the museum.
	 * @return the <code>Museum</code> instance representing a register in the
	 * database with given <code>name</code>. If the register can't be found,
	 * <code>null</code> is returned.
	 */
	public Museum findByName(String name) {
		Museum m = new Museum();
		m.setName(name);
		return findMuseum(m);
	}

	/**
	 * Searchs for the register corresponding with given <code>object</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Museum museum = new Museum().
	 * museum.setId(1L);
	 * MuseumService service = new MuseumService();
	 * museum = service.findMuseum(museum);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param museum the museumt to be searched in the database.
	 * @return the <code>MuseologicalObject</code> instance representing a
	 * register in the database. If the register can't be found,
	 * <code>null</code> is returned.
	 */
	private Museum findMuseum(Museum museum) {
		MuseumDO mdo = new MuseumDO();

		mdo.setId(museum.getId());
		mdo.setName(museum.getName());
		mdo = (MuseumDO) dao.findEntity(mdo);

		return mdo == null ? null : mdo.getDto();
	}

	/**
	 * Lists all the museums.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * MuseumService service = new MuseumService();
	 * List&lt;Museum&gt; museums = service.listMuseum();
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @return the <code>List</code> of all <code>Museum</code> stored in the
	 * database.
	 */
	public List<Museum> listMuseum() {
		List<MuseumDO> mdos = dao.listMuseums();
		List<Museum> mus = new ArrayList<Museum>();
		for (MuseumDO mdo : mdos) {
			mus.add(mdo.getDto());
		}
		return mus;
	}

	/**
	 * Deletes an <code>Annotation</code> stored in the database.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * MuseumService service = new MuseumService();
	 * Museum museum = service.findById(1L);
	 * service.deleteMuseum(museum.getId());
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param id the <code>id</code> of <code>Museum</code> to be deleted.
	 */
	public void deleteMuseum(Long id) {
		MuseumDO mdo = new MuseumDO();

		mdo.setId(id);

		dao.deleteMuseum(mdo);
	}
}
