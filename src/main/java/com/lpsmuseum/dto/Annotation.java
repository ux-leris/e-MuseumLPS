package com.lpsmuseum.dto;

import com.lpsmuseum.dao.MuseologicalObjectDAO;
import com.lpsmuseum.dao.MuseumDAO;
import com.lpsmuseum.entity.AnnotationDO;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.MuseumDO;

/**
 * This class represents an annotation, just for transfer between client-side 
 * and server-side
 * @author USER
 */
public class Annotation {
	
	/**
	 * An annotation identification.
	 */
	private Long id;
	
	/**
	 * An annotation author's name.
	 */
	private String author;
	
	/**
	 * An annotation title;
	 */
	private String title;
	
	/**
	 * An annotation content.
	 */
	private String content;
	
	/**
	 * An identification of the museum which this annotation is related.
	 */
	private Long idMuseum;
	
	/**
	 * An identification of the museological object which this annotation is related.
	 */
	private Long idObject;

	/**
	 * Gets the id registered for this annotation;
	 * 
	 * @return a Long value representing the id registered for this annotation.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Registers the id for this annotation.
	 * 
	 * @param id a Long value representing the id to be registered for this 
	 * annotation.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name of the author of this annotation.
	 * 
	 * @return a String value representing the author's name.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Registers the name of the author of this annotation.
	 * 
	 * @param author a String value representing the author's name to be 
	 * registered for this annotation.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the title for this annotation.
	 * 
	 * @return a String value representing the title registered fot his annotation
	 * .
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Registers the title for this annotation.
	 * 
	 * @param title a String value representing the title to be registered for 
	 * this annotation.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the content of this annotation.
	 * 
	 * @return a String value representing the content for this annotation.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Registers a content for this annotation.
	 * 
	 * @param content a String value representing the content to be registered 
	 * for thia annotation.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the id of the museum which this annotation is related.
	 * 
	 * @return a Long value representing the id of the museum.
	 * @see Museum
	 */
	public Long getIdMuseum() {
		return idMuseum;
	}

	/**
	 * Registers the id for the museum which this annotation is related.
	 * 
	 * @param idMuseum a Long value representing the id of the museum.
	 * @see Museum
	 */
	public void setIdMuseum(Long idMuseum) {
		this.idMuseum = idMuseum;
	}

	/**
	 * Gets the id of the museological object which this annotation is related.
	 * 
	 * @return a Long value representing the id of the museological object.
	 * @see MuseologicalObject
	 */
	public Long getIdObject() {
		return idObject;
	}

	/**
	 * Registers the id for the museological object which this annotation is 
	 * related.
	 * 
	 * @param idObject a Long value representing the id of the museological object.
	 * @see MuseologicalObject
	 */
	public void setIdObject(Long idObject) {
		this.idObject = idObject;
	}

	/**
	 * Gets the entity representation for this annotation
	 * 
	 * @return a AnnotationDO object representing this annotation.
	 * @see AnnotationDO
	 */
	public AnnotationDO getEntity() {
		AnnotationDO ado = new AnnotationDO();
		ado.setAuthor(author);
		ado.setContent(content);
		ado.setId(id);
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
		ado.setTitle(title);
		return ado;
	}

}
