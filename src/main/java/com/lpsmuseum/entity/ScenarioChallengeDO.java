package com.lpsmuseum.entity;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.dto.scenario.ScenarioChallenge;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * An entity class for scenario's table (with name <code>scenario</code>) when 
 * him has challenges. This entity generate a new table (<code>
 * scenario_challenge</code> with columns for:
 * <ul>
 * <li>A scenario's id
 * <li>A challenge's id
 * </ul>
 * <p>
 * Regardless of this, the scenario's table has one new many-to-many relationship
 * with challenge's table, whom generated the table <code>
 * scenario_challenge</code>.
 *
 * @serial
 * @see ScenarioDO
 * @see ChallengeDO
 */
@Entity
@DiscriminatorValue(value = "ScenarioChallengeDO")
@SuppressWarnings("serial")
public class ScenarioChallengeDO extends ScenarioDO {
	
	/**
	 * This field represents the many-to-many relationship between scenario and
	 * challenge's table. The relationship generate the table <code>
	 * scenario_challenge</code>, doing the join with respective id of each 
	 * table.
	 * <p>
	 * The fetch type for the objects of type <code>Scenario</code> is <b>eager
	 * </b>, so all the objects are loaded only once.
	 *
	 * @see FetchType
	 * @see ChallengeDO
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="scenario_challenge", joinColumns={@JoinColumn(name="id_scenario")}, inverseJoinColumns={@JoinColumn(name="id_challenge")})
	private List<ChallengeDO> challenges;

	/**
	 * Class constructor.
	 * <p>
	 * Initializes this with a empty list of challenges.
	 */
	public ScenarioChallengeDO() {
		challenges = new ArrayList<ChallengeDO>();
	}

	/**
	 * Returns the list of challenges (entity like) related to this scenario.
	 *
	 * @return the list of challenges related to this scenario.
	 */
	public List<ChallengeDO> getChallenges() {
		return challenges;
	}

	/**
	 * Sets the list of challenges (entity like) related to this scenario.
	 * 
	 * @param challenges the list of challenges related to this scenario.
	 */
	public void setChallenges(List<ChallengeDO> challenges) {
		this.challenges = challenges;
	}

	@Override
	public Scenario getDto() {
		ScenarioChallenge scenarioChallenge;
		
		List<MuseologicalObject> objects = new ArrayList<MuseologicalObject>();
		for (MuseologicalObjectDO object : getObjects())
			objects.add(object.getDto());
		List<Challenge> challenges = new ArrayList<Challenge>();
		for (ChallengeDO challenge : this.challenges)
			challenges.add(challenge.getDto());
		scenarioChallenge = new ScenarioChallenge(getName(), objects, challenges);
		scenarioChallenge.setId(getId());
		scenarioChallenge.setTheme(getTheme().getDto());
		
		return scenarioChallenge;
	}
	
	
}
