package com.lpsmuseum.dto;

import com.lpsmuseum.dao.MuseologicalObjectDAO;
import com.lpsmuseum.dao.MuseumDAO;
import com.lpsmuseum.entity.AnnotationDO;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.MuseumDO;

/**
 * This class represents an <b>annotation</b>, just for transfer between client-side 
 * and server-side.
 */
public class Annotation {
	
	/**
	 * This field represents the annotation's id.
	 */
	private Long id;
	
	/**
	 * This field represents the annotation's author.
	 */
	private String author;
	
	/**
	 * This field represents the annotation's title;
	 */
	private String title;
	
	/**
	 * This fields represents the annotation's content.
	 */
	private String content;
	
	/**
	 * This field represents the museum's id which this annotation is related.
	 */
	private Long idMuseum;
	
	/**
	 * This field represents the museological object's id which this annotation 
	 * is related.
	 */
	private Long idObject;

	/**
	 * Class constructor.
	 */
	public Annotation() {
	}

	/**
	 * Returns the <code>id</code> of this <code>Annotation</code> instance.
	 *
	 * @return the <code>id</code> of this <code>Annotation</code> instance.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the <code>id</code> of this <code>Annotation</code> instance.
	 *
	 * @param id the <code>id</code> of this <code>Annotation</code> instance.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the <code>title</code> of this <code>Annotation</code> instance.
	 *
	 * @return the <code>title</code> of this <code>Annotation</code> instance.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the <code>title</code> of this <code>Annotation</code> instance.
	 *
	 * @param title the <code>title</code> of this <code>Annotation</code> 
	 * instance.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Returns the <code>content</code> of this <code>Annotation</code> 
	 * instance.
	 * 
	 * @return the <code>content</code> of this <code>Annotation</code> 
	 * instance.
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the <code>content</code> of this <code>Annotation</code> instance.
	 * 
	 * @param content the <code>content</code> of this <code>Annotation</code> 
	 * instance.
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Returns the <code>author</code> of this <code>Annotation</code> instance.
	 * 
	 * @return the <code>author</code> of this <code>Annotation</code> instance.
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Sets the <code>author</code> of this <code>Annotation</code> instance.
	 * 
	 * @param author the <code>author</code> of this <code>Annotation</code> 
	 * instance.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Returns the id of the <code>Museum</code> which this <code>Annotation
	 * </code> instance is related.
	 * 
	 * @return the id of the <code>Museum</code> which this <code>Annotation
	 * </code> instance is related.
	 */
	public Long getIdMuseum() {
		return idMuseum;
	}

	/**
	 * Sets the id for the <code>Museum</code> which this <code>Annotation
	 * </code> instance is related.
	 * 
	 * @param idMuseum the id of the <code>Museum</code> which this <code>
	 * Annotation</code> instance is related.
	 */
	public void setIdMuseum(Long idMuseum) {
		this.idMuseum = idMuseum;
	}

	/**
	 * Returns the id of the <code>MuseologicalObject</code> which this <code>
	 * Annotation</code> instance is related.
	 * 
	 * @return the id of the <code>MuseologicalObject</code> which this <code>
	 * Annotation</code> instance is related.
	 */
	public Long getIdObject() {
		return idObject;
	}

	/**
	 * Sets the id for the <code>MuseologicalObject</code> which this <code>
	 * Annotation</code> instance is related.
	 * 
	 * @param idObject the id of the <code>MuseologicalObject</code> which this 
	 * <code>Annotation</code> instance 
	 * is related.
	 */
	public void setIdObject(Long idObject) {
		this.idObject = idObject;
	}

	/**
	 * Returns the entity representation (<code>AnnotationDO</code>) for this 
	 * <code>Annotation</code> instance.
	 * 
	 * @return the entity representation (<code>AnnotationDO</code>) for this 
	 * <code>Annotation</code> instance.
	 * @see AnnotationDO
	 */
	public AnnotationDO getEntity() {
		AnnotationDO ado = new AnnotationDO();
		
		ado.setId(id);
		ado.setTitle(title);
		ado.setContent(content);
		ado.setAuthor(author);
		
		if (idMuseum != null) {
			for (MuseumDO museumDO : new MuseumDAO().listMuseums()) {
				if (museumDO.getId().compareTo(idMuseum) == 0) {
					ado.setMuseum(museumDO);
					break;
				}
			}
		}
		
		if (idObject != null) {
			for (MuseologicalObjectDO museologicalObjectDO : new MuseologicalObjectDAO()
					.listObjects()) {
				if (museologicalObjectDO.getId().compareTo(idObject) == 0) {
					ado.setObject(museologicalObjectDO);
					break;
				}
			}
		}
		
		return ado;
	}

}
