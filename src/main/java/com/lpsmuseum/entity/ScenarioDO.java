package com.lpsmuseum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.service.ThemeService;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;

/**
 * An entity class for scenario's table (with name <code>scenario</code>). The 
 * table has columns for:
 * <ul>
 * <li>An id
 * <li>A name
 * <li>A type descriminator
 * <li>A museum's id
 * <li>A theme's id
 * </ul>
 * <p>
 * Regardless of this, the scenario's table has one many-to-many relationship
 * with museological object's table, whom generated the table scenario_object.
 * <p>
 * This entity can be specialized to represent <b>scenarios with challenges</b>
 * . For such, this entity has a <u>type descriminator</u> column of type 
 * <code>String</code> and the possible values are:
 * <ul>
 * <li>ScenarioDO: for scenarios without challenges
 * <li>ScenarioChallengeDO: for scenarios with challenges
 * </ul>
 *
 * @serial
 * @see ScenarioChallengeDO
 * @see MuseologicalObjectDO
 */
@Entity
@Table(name = "scenario")
@Inheritance
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "ScenarioDO")
public class ScenarioDO implements Serializable {

	/**
	 * This field is the <b>primary key</b> of the table (so can't be null by
	 * default) and is <u>auto generated</u> sequentially. The column's name in
	 * the table is <code>id_scenario</code>.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scenario")
	private Long id;

	/**
	 * This field represents the scenario's name and can't be null. The column's
	 * name in the table is <code>name</code>.
	 */
	@NotNull
	@Column(name = "name")
	private String name;

	/**
	 * This field represents the many-to-many relationship between scenario and
	 * museological object's table. The relationship generate the table <code>
	 * scenario_object</code>, doing the join with respective id of each table.
	 * <p>
	 * The fetch type for the objects of type <code>Scenario</code> is <b>eager
	 * </b>, so all the objects are loaded only once.
	 *
	 * @see FetchType
	 * @see MuseologicalObjectDO
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "scenario_object", joinColumns = {
		@JoinColumn(name = "id_scenario")}, inverseJoinColumns = {
		@JoinColumn(name = "id_object")})
	private List<MuseologicalObjectDO> objects;

	/**
	 * This field represents the many-to-one relationship between scenario and
	 * museum's table.
	 *
	 * @see MuseumDO
	 */
	@ManyToOne
	@JoinColumn(name = "id_museum")
	private MuseumDO museum;

	/**
	 * This field represents the many-to-one relationship between scenario and
	 * theme's table.
	 *
	 * @see ThemeDO
	 */
	@ManyToOne
	@JoinColumn(name = "id_theme")
	private ThemeDO theme;

	/**
	 * Class constructor.
	 * <p>
	 * Initializes this with a empty list of museological objects.
	 */
	public ScenarioDO() {
		objects = new ArrayList<MuseologicalObjectDO>();
	}

	/**
	 * Returns the id of this scenario.
	 *
	 * @return the id of this scenario.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id of this scenario.
	 *
	 * @param id the id of this scenario.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the name of this scenario.
	 *
	 * @return the name of this scenario.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this scenario.
	 *
	 * @param name the name of this scenario.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the list of museological objects (entity like) in the scenario.
	 *
	 * @return the list of museological objects in the scenario.
	 */
	public List<MuseologicalObjectDO> getObjects() {
		return objects;
	}

	/**
	 * Sets the list of museological objects (entity like) in the scenario.
	 *
	 * @param objects the list of museological objects in the scenario.
	 */
	public void setObjects(List<MuseologicalObjectDO> objects) {
		this.objects = objects;
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
	 * Returns the theme (entity like) of this scenario.
	 *
	 * @return the theme of this scenario.
	 */
	public ThemeDO getTheme() {
		return theme;
	}

	/**
	 * Sets the theme (entity like) of this scenario.
	 *
	 * @param theme the theme of this scenario.
	 */
	public void setTheme(ThemeDO theme) {
		this.theme = theme;
	}

	/**
	 * Returns the transfer object representing this scenario.
	 * <p>
	 * Note that <code>objects</code> are entities, so they need to be converted
	 * one by one.
	 *
	 * @return the transfer object representing this scenario.
	 */
	public Scenario getDto() {
		Scenario s = new Scenario(getName());

		s.setId(getId());
		for (MuseologicalObjectDO obj : getObjects()) {
			s.getObjects().add(obj.getDto());
		}
		if (museum != null) {
			s.setIdMuseum(museum.getId());
		}
		s.setTheme(new ThemeService().getDto(theme));

		return s;
	}
}
