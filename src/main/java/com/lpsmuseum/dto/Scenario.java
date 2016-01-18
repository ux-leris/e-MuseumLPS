package com.lpsmuseum.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.MuseumDO;
import com.lpsmuseum.entity.ScenarioDO;
import com.lpsmuseum.service.MuseologicalObjectService;

/**
 * This class represents a <b>scenario</b>, just for transfer between 
 * client-side and server-side.
 */
public class Scenario {

	/**
	 * This field represents the annotation's id.
	 */
	private Long id;
	
	/**
	 * This field represents the annotation's name.
	 */
	private String name;
	
	/**
	 * This field represents a <code>List</code> of museological objects in this museum.
	 */
	private List<MuseologicalObject> objects;
	
	/**
	 * This field represents the scenario's date.
	 */
	private Calendar date;
	
	/**
	 * This field represents the museum's id which this annotation is related.
	 */
	private Long idMuseum;
	
	/**
	 * This field represents the scenario's theme.
	 */
	private Theme theme;

	/**
	 * Class constructor.
	 */
	public Scenario() {
	}

	/**
	 * Class constructor with given name with empty <code>List</code> of <code>
	 * MuseologicalObject</code>.
	 * 
	 * @param name the name of this <code>Scenario</code> instance.
	 */
	public Scenario(String name) {
		this(name, new ArrayList<MuseologicalObject>());
	}

	/**
	 * Class constructor with given <code>name</code> and <code>List</code> of 
	 * <code>MuseologicalObject</code>.
	 * 
	 * @param name the <code>name</code> of this <code>Scenario</code> instance.
	 * @param objects the <code>List</code> of <code>MuseologicalObject</code> 
	 * of this <code>Scenario</code> instance.
	 */
	public Scenario(String name, List<MuseologicalObject> objects) {
		this.name = name;
		this.objects = objects;
	}

	/**
	 * Returns the <code>id</code> of this <code>Scenario</code> instance.
	 *
	 * @return the <code>id</code> of this <code>Scenario</code> instance.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the <code>id</code> of this <code>Scenario</code> instance.
	 *
	 * @param id the <code>id</code> of this <code>Scenario</code> instance.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the <code>name</code> of this <code>Scenario</code> instance.
	 *
	 * @return the <code>name</code> of this <code>Scenario</code> instance.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the <code>name</code> of this <code>Scenario</code> instance.
	 *
	 * @param name the <code>name</code> of this <code>Scenario</code> instance.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the <code>List</code> of <code>MuseologicalObject</code> of this 
	 * <code>Scenario</code> instance.
	 * 
	 * @return the <code>List</code> of <code>MuseologicalObject</code> of this 
	 * <code>Scenario</code> instance.
	 */
	public List<MuseologicalObject> getObjects() {
		return objects;
	}

	/**
	 * Sets the <code>List</code> of <code>MuseologicalObject</code> of this 
	 * <code>Scenario</code> instance.
	 * 
	 * @param objects the <code>List</code> of <code>MuseologicalObject</code> 
	 * of this <code>Scenario</code> instance.
	 */
	public void setObjects(List<MuseologicalObject> objects) {
		this.objects = objects;
	}

	/**
	 * Returns the <code>id</code> of the <code>Museum</code> which this <code>
	 * Scenario</code> is related.
	 * 
	 * @return the <code>id</code> of the <code>Museum</code> which this <code>
	 * Scenario</code> is related.
	 */
	public Long getIdMuseum() {
		return idMuseum;
	}

	/**
	 * Sets the <code>id</code> of the <code>Museum</code> which this <code>
	 * Scenario</code> is related.
	 * 
	 * @param idMuseum the <code>id</code> of the <code>Museum</code> which 
	 * this <code>Scenario</code> is related.
	 */
	public void setIdMuseum(Long idMuseum) {
		this.idMuseum = idMuseum;
	}

	/**
	 * Returns the <code>Theme</code> of this <code>Scenario</code> instance.
	 * 
	 * @return the <code>Theme</code> of this <code>Scenario</code> instance.
	 */
	public Theme getTheme() {
		return theme;
	}

	/**
	 * Sets the <code>Theme</code> of this <code>Scenario</code> instance.
	 * 
	 * @param theme the <code>Theme</code> of this <code>Scenario</code> 
	 * instance.
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	/**
	 * Returns the entity representation (<code>ScenarioDO</code>) for this 
	 * <code>Scenario</code> instance.
	 * 
	 * @return the entity representation (<code>ScenarioDO</code>) for this 
	 * <code>Scenario</code> instance.
	 * @throws Exception If <code>Scenario.getEntity</code> rises a exception.
	 * @see MuseumDO
	 * @see Scenario
	 */
	public ScenarioDO getEntity() throws Exception {
		ScenarioDO scenarioDO = new ScenarioDO();
		
		scenarioDO.setName(getName());
		scenarioDO.setId(getId());
		scenarioDO.setTheme(theme.getEntity());
		
		if (idMuseum != null) {
			MuseumDO mdo = new MuseumDO();
			mdo.setId(idMuseum);
			scenarioDO.setMuseum(mdo);
		}
		
		for (MuseologicalObject obj : getObjects()) {
			MuseologicalObjectDO objDO = new MuseologicalObjectService().findEntity(obj);
			if (objDO != null) {
				scenarioDO.getObjects().add(objDO);
			} else {
				throw new Exception("Could not find object " + obj.getName() + "!");
			}
		}
		
		return scenarioDO;
	}

	/**
	 * Sets and returns the lowest time of all <code>MuseologicalObject</code> 
	 * of this <code>Senario</code> instance.
	 * 
	 * @return the historical time of this <code>Scenario</code> instance.
	 */
	public Calendar getHistoricalTime() {
		sortScenario();
		return date;
	}

	/**
	 * Sorts the <code>List</code> of <code>MuseologicalObject</code> of this 
	 * <code>Senario</code> instance.
	 * <p>
	 * The method of comparison is by <u>ascending historical time</u>.
	 */
	private void sortScenario() {
		if (objects.size() > 0) {
			Collections.sort(objects, new Comparator<MuseologicalObject>() {
				public int compare(MuseologicalObject obj1, MuseologicalObject obj2) {
					return obj1.getDate().compareTo(obj2.getDate());
				}
			});
			date = objects.get(0).getDate();
		}
	}
}
