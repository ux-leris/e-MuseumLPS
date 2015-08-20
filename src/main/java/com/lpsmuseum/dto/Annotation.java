package com.lpsmuseum.dto;

import com.lpsmuseum.dao.MuseologicalObjectDAO;
import com.lpsmuseum.dao.MuseumDAO;
import com.lpsmuseum.entity.AnnotationDO;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.MuseumDO;

public class Annotation {
	private Long id;
	private String author;
	private String title;
	private String content;
	private Long idMuseum;
	private Long idObject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public Long getIdMuseum() {
		return idMuseum;
	}

	public void setIdMuseum(Long idMuseum) {
		this.idMuseum = idMuseum;
	}

	public Long getIdObject() {
		return idObject;
	}

	public void setIdObject(Long idObject) {
		this.idObject = idObject;
	}

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
