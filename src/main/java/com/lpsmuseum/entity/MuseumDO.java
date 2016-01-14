package com.lpsmuseum.entity;

import com.lpsmuseum.dto.Museum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * An entity class for museum's table (with name museum). The table has columns
 * for:
 * <ul>
 * <li>An id
 * <li>A name
 * </ul>
 * <p>
 * Regardless of this, in the scenario's table has an column for the one-to-many
 * relationship between them.
 *
 * @serial
 * @see ScenarioDO
 */
@Entity
@Table(name = "museum")
public class MuseumDO implements Serializable {

	/**
	 * This field is the <b>primary key</b> of the table (so can't be null by
	 * default) and is <u>auto generated</u> sequentially. The column's name in
	 * the table is <code>id_museum</code>.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_museum")
	private Long id;

	/**
	 * This field represents the museum's name and can't be null. The column's
	 * name in the table is <code>name</code>.
	 */
	@NotNull
	@Column(name = "name")
	private String name;

	/**
	 * This field represents the one-to-many relationship between museum and
	 * scenario's table. In scenario's table, the column's name is <code>id_museum
	 * </code>.
	 * <p>
	 * The fetch type for the objects of type <code>Scenario</code> is <b>eager
	 * </b>, so all the objects are loaded only once.
	 *
	 * @see FetchType
	 */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_museum")
	private List<ScenarioDO> scenarios;

	/**
	 * Class constructor.
	 * <p>
	 * Initializes This with a empty list of scenarios.
	 */
	public MuseumDO() {
		scenarios = new ArrayList<ScenarioDO>();
	}

	/**
	 * Returns the id of this museum.
	 *
	 * @return the id of this museum.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id of this museum.
	 *
	 * @param id the id of this museum.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the name of the museum.
	 *
	 * @return the name of the museum.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the museum.
	 *
	 * @param name the name of the museum.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the list of scenarios (entity like) in the museum.
	 *
	 * @return the list of scenarios in the museum.
	 */
	public List<ScenarioDO> getScenarios() {
		return scenarios;
	}

	/**
	 * Sets the list of scenarios (entity like) in the museum.
	 *
	 * @param scenarios the list of scenarios in the museum.
	 */
	public void setScenarios(List<ScenarioDO> scenarios) {
		this.scenarios = scenarios;
	}

	/**
	 * Returns the transfer object representing this museum.
	 * <p>
	 * Note that <code>scenarios</code> are entities, so they need to be
	 * converted one by one.
	 *
	 * @return the transfer object representing this museum.
	 */
	public Museum getDto() {
		Museum m = new Museum();

		m.setId(id);
		m.setName(name);
		for (ScenarioDO s : scenarios) {
			m.getScenarios().add(s.getDto());
		}

		return m;
	}
}
