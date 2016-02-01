package com.lpsmuseum.entity;

import com.lpsmuseum.dto.Annotation;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * An entity class for annotation's table (with name <code>annotation</code>). 
 * The table has columns for:
 * <ul>
 * <li>An id
 * <li>A title
 * <li>A content
 * <li>An author
 * <li>An id from the museum
 * <li>An id from the museological object
 * </ul>
 *
 * @serial
 */
@Entity
@Table(name="annotation")
@SuppressWarnings("serial")
public class AnnotationDO implements Serializable {
	
	/**
	 * This field is the <b>primary key</b> of the table (so can't be null by
	 * default) and is <u>auto generated</u> sequentially. The column's name in
	 * the table is <code>id_annotation</code>.
	 */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_annotation")
	private Long id;
	
	/**
	 * This field represents the annotation's title. The column's name in the 
	 * table is <code>title</code>.
	 */
	// FIX Annotation's title can be null?
	@Column(name="title")
	private String title;
	/**
	 * This field represents the annotation's content. The column's name in the 
	 * table is <code>content</code>.
	 */
	// FIX Annotation's content can be null?
	@Column(name="content")
	private String content;
	
	/**
	 * This field represents the annotation's author. The column's name in the 
	 * table is <code>author</code>.
	 */
	@Column(name="author")
	private String author;
	
	/**
	 * This field represents the many-to-one relationship between annotation 
	 * and museum's table.
	 *
	 * @see MuseumDO
	 */
	@ManyToOne
	@JoinColumn(name = "id_museum")
	private MuseumDO museum;
	
	/**
	 * This field represents the many-to-one relationship between annotation 
	 * and museological object's table.
	 *
	 * @see MuseologicalObjectDO
	 */
	@ManyToOne
	@JoinColumn(name = "id_object")
	private MuseologicalObjectDO object;

	/**
	 * Class constructor.
	 */
	public AnnotationDO() {
	}
	
	/**
	 * Returns the id of the annotation.
	 *
	 * @return the id of the annotation.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id of this annotation.
	 *
	 * @param id the id of this annotation.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the title of this annotation.
	 *
	 * @return the title of this annotation.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of this annotation.
	 *
	 * @param title the title of this annotation.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Returns the content of this annotation.
	 * 
	 * @return the content of this annotation.
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the content of this annotation.
	 * 
	 * @param content the content of this annotation.
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Returns the author of this annotation.
	 * 
	 * @return the author of this annotation.
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Sets the author of this annotation.
	 * 
	 * @param author the author of this annotation.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Returns the museum (entity like) what this is related.
	 *
	 * @return the museum what this is related.
	 */
	public MuseumDO getMuseum() {
		return museum;
	}

	/**
	 * Sets the museum (entity like) what this is related.
	 *
	 * @param museum the museum what this is related.
	 */
	public void setMuseum(MuseumDO museum) {
		this.museum = museum;
	}
	
	/**
	 * Returns the museological object (entity like) what this is related.
	 *
	 * @return the museological object what this is related.
	 */
	public MuseologicalObjectDO getObject() {
		return object;
	}
	
	/**
	 * Sets the museological object (entity like) what this is related.
	 *
	 * @param object the museological object what this is related.
	 */
	public void setObject(MuseologicalObjectDO object) {
		this.object = object;
	}
	
	/**
	 * Returns the transfer object representing this annotation.
	 *
	 * @return the transfer object representing this annotation.
	 */
	public Annotation getDto() {
		Annotation annotation = new Annotation();
		
		annotation.setId(id);
		annotation.setTitle(title);
		annotation.setContent(content);
		if (museum != null) {
			annotation.setIdMuseum(museum.getId());
		}
		if (object != null) {
			annotation.setIdObject(object.getId());
		}
		
		return annotation;
	}
}
