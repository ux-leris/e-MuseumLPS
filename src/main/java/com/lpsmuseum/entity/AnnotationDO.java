package com.lpsmuseum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="annotation")
@SuppressWarnings("serial")
public class AnnotationDO implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_annotation")
	private Long id;
	@Column(name="title")
	private String title;
	@Column(name="content")
	private String content;
	@Column(name="author")
	private String author;
	@ManyToOne
	@JoinColumn(name = "id_museum")
	private MuseumDO museum;
	@ManyToOne
	@JoinColumn(name = "id_object")
	private MuseologicalObjectDO object;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MuseumDO getMuseum() {
		return museum;
	}
	public void setMuseum(MuseumDO museum) {
		this.museum = museum;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public MuseologicalObjectDO getObject() {
		return object;
	}
	public void setObject(MuseologicalObjectDO object) {
		this.object = object;
	}
}
