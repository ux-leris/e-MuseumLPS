package com.lpsmuseum.service;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dao.AnnotationDAO;
import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.entity.AnnotationDO;

/**
 * This class provides services to work with <b>annotations</b>.
 *
 * <p>
 * The services available are all the CRUD operations.
 *
 * @see Annotation
 */
public class AnnotationService {

	/**
	 * This fields provides communication with the database.
	 */
	private final AnnotationDAO dao = new AnnotationDAO();

	/**
	 * Class constructor.
	 */
	public AnnotationService() {
	}

	/**
	 * Creates a new register in the database for an <code>Annotation</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Annotation annotation = new Annotation();
	 * // Getters call on annotation
	 * AnnotationService service = new AnnotationService();
	 * service.createAnnotation(annotation);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param annotation the <code>Annotation</code> instance to be registered
	 * in the database.
	 */
	public void createAnnotation(Annotation annotation) {
		AnnotationDO ado = annotation.getEntity();

		dao.createAnnotation(ado);

		annotation.setId(ado.getId());
	}

	/**
	 * Searchs for the annotation with given <code>id</code>.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Long id = 1L;
	 * AnnotationService service = new AnnotationService();
	 * Annotation annotation = service.findById(id);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param id the id of the annotation.
	 * @return the <code>Annotation</code> instance representing a register in 
	 * the database with given <code>id</code>. If the register can't be found, 
	 * <code>null</code> is returned.
	 */
	public Annotation findById(Long id) {
		Annotation an = new Annotation();
		
		an.setId(id);
		
		return findAnnotation(an);
	}

	/**
	 * Searchs for the annotation with given <code>title</code>.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * String title = "This is a string title";
	 * AnnotationService service = new AnnotationService();
	 * Annotation annotation = service.findByTitle(title);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param title the title of the annotation.
	 * @return the <code>Annotation</code> instance representing a register in 
	 * the database with given <code>title</code>. If the register can't be 
	 * found, <code>null</code> is returned.
	 */
	public Annotation findByTitle(String title) {
		Annotation an = new Annotation();
		
		an.setTitle(title);
		
		return findAnnotation(an);
	}

	/**
	 * Searchs for the register corresponding with given <code>annotation</code>.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Annotation annotation = new Annotation().
	 * annotation.setId(1L);
	 * AnnotationService service = new AnnotationService();
	 * Annotation annotation = service.findAnnotation(annotation);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param annotation the annotation to be searched in the database.
	 * @return the <code>Annotation</code> instance representing a register in 
	 * the database. If the register can't be found, <code>null</code> is 
	 * returned.
	 */
	private Annotation findAnnotation(Annotation annotation) {
		AnnotationDO ado = (AnnotationDO) dao.findEntity(annotation.getEntity());
		
		return ado == null ? null : ado.getDto();
	}

	/**
	 * Lists all the annotations related to given object.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Long id = museologicalObject.getId();
	 * AnnotationService service = new AnnotationService();
	 * List&lt;Annotation&gt; annotations = service.listByObject(id);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param objectId the <code>id</code> of the <code>MuseologicalObject</code>.
	 * @return the <code>List</code> of <code>Annotation</code> related to given 
	 * <code>MuseologicalObject</code>.
	 */
	public List<Annotation> listByObject(Long objectId) {
		List<AnnotationDO> ados = dao.listByObject(objectId);
		
		return listAnnotation(ados);
	}

	/**
	 * Lists all the annotations related to given museum.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Long id = museum.getId();
	 * AnnotationService service = new AnnotationService();
	 * List&lt;Annotation&gt; annotations = service.listByMuseum(id);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param museumId the <code>id</code> of the <code>Museum</code>.
	 * @return the <code>List</code> of <code>Annotation</code> related to given 
	 * <code>Museum</code>.
	 */
	public List<Annotation> listByMuseum(Long museumId) {
		List<AnnotationDO> ados = dao.listByMuseum(museumId);
		
		return listAnnotation(ados);
	}

	/**
	 * Lists all the annotations.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * AnnotationService service = new AnnotationService();
	 * List&lt;Annotation&gt; annotations = service.listAnnotations();
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @return the <code>List</code> of all <code>Annotation</code> stored in the 
	 * database.
	 */
	public List<Annotation> listAnnotations() {
		List<AnnotationDO> ados = dao.listAnnotations();
		
		return listAnnotation(ados);
	}

	/**
	 * Converts a <code>List</code> of <code>AnnotationDO</code> in a <code>List
	 * </code> of <code>Annotation</code>.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * AnnotationService service = new AnnotationService();
	 * List&lt;AnnotationDO&gt; ados = new AnnotationDAO().listAnnotations();
	 * List&lt;Annotation&gt; annotations = service.listAnnotation(ados);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param ados the <code>List</code> of <code>AnnotationDO</code> to be 
	 * converted.
	 * @return the <code>List</code> of <code>Annotation</code>.
	 */
	private List<Annotation> listAnnotation(List<AnnotationDO> ados) {
		ArrayList<Annotation> ans = new ArrayList<Annotation>();
		
		for (AnnotationDO ado : ados) {
			ans.add(ado.getDto());
		}
		
		return ans;
	}

	/**
	 * Updates an <code>Annotation</code> stored in the database.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * AnnotationService service = new AnnotationService();
	 * Annotation annotation = service.findByTitle("Older annotation");
	 * annotation.setTitle("New annotation");
	 * service.editAnnotation(annotation);
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param annotation the <code>Annotation</code> to be updated.
	 */
	public void editAnnotation(Annotation annotation) {
		dao.editAnnotation(annotation.getEntity());
	}

	/**
	 * Deletes an <code>Annotation</code> stored in the database.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * AnnotationService service = new AnnotationService();
	 * Annotation annotation = service.findByTitle("Older annotation");
	 * service.deleteAnnotation(annotation.getId());
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param id the <code>id</code> of <code>Annotation</code> to be deleted.
	 */
	public void deleteAnnotation(Long id) {
		AnnotationDO ado = new AnnotationDO();
		
		ado.setId(id);
		
		dao.deleteAnnotation(ado);
	}
}
