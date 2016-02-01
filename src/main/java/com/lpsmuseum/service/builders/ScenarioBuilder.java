package com.lpsmuseum.service.builders;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.dto.scenario.ScenarioChallenge;
import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.service.ScenarioService;

/**
 * This class provides a <b>builder</b> to creates <code>Scenario</code>.
 *
 * @see Scenario
 */
public class ScenarioBuilder {

	private final List<MuseologicalObject> objects = new ArrayList<MuseologicalObject>();
	private final List<Challenge> challenges = new ArrayList<Challenge>();
	private Theme theme = null;

	/**
	 * Builds a <code>Scenario</code> instance with actual state.
	 *
	 * @param name the <code>name</code> of the scenario.
	 * @return the builded <code>Scenario</code> instance.
	 * @throws Exception if <code>Scenario.getEntity</code> rises a exception.
	 * @see Scenario
	 */
	public Scenario build(String name) throws Exception {
		Scenario s;
		if (challenges.isEmpty()) {
			s = new Scenario(name, objects);
		} else {
			s = new ScenarioChallenge(name, objects, challenges);
		}
		if (theme == null) {
			throw new Exception("Theme must not be null!");
		}
		s.setTheme(theme);
		ScenarioService svc = new ScenarioService();
		svc.createScenario(s);
		return s;
	}

	/**
	 * Adds a new museological object to be related to the <code>Scenario
	 * </code> instance to be builded.
	 *
	 * @param obj the <code>MuseologicalObject</code> to be added.
	 * @return this builder instance itself.
	 */
	public ScenarioBuilder withObject(MuseologicalObject obj) {
		objects.add(obj);

		return this;
	}

	/**
	 * Adds a new challenge to be related to the <code>Scenario</code> instance
	 * to be builded.
	 *
	 * @param obj the <code>Challenge</code> to be added.
	 * @return this builder instance itself.
	 */
	public ScenarioBuilder withChallenge(Challenge challenge) {
		challenges.add(challenge);

		return this;
	}

	/**
	 * Sets the theme of the scenario.
	 *
	 * @param theme the theme of the scenario.
	 * @return this builder instance itself.
	 */
	public ScenarioBuilder withTheme(Theme theme) {
		this.theme = theme;

		return this;
	}

	/**
	 * Clears the state of this builder.
	 *
	 * @return this builder instance itself.
	 */
	public ScenarioBuilder clear() {
		challenges.clear();
		objects.clear();
		theme = null;

		return this;
	}
}
