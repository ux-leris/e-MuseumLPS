package br.ufscar.sor.dcomp.ihc.muvi.model;

import com.lpsmuseum.behaviour.museum.Navigation;
import com.lpsmuseum.behaviour.museum.navigation.AleatoryNavigation;
import com.lpsmuseum.behaviour.museum.navigation.GuidedNavigation;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Theme;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author USER
 */
public class MuviMuseum extends Museum {

	private Museum museum;
	private List<Scenario> scenarios = new ArrayList<Scenario>();
	private List<Theme> themes = new ArrayList<Theme>();

	public MuviMuseum(Museum museum) {
		this.museum = museum;
		setId(museum.getId());
		setName(museum.getName());
		setNavigation(museum.getNavigation());
		setScenarios(museum.getScenarios());
	}

	@Override
	public Museum setNavigation(Navigation navigation) {
		super.setNavigation(navigation);
		museum.setNavigation(navigation);
		return this;
	}

	@Override
	public List<Scenario> getScenarios() {
		return scenarios;
	}

	public Node navigate() {
		// Não funciona, resulta em NoSuchMethodError
		//return museum.getNavigation().getNavigation(museum.getScenarios());
		List<Scenario> temp = this.scenarios;
		Node node;
		if (museum.getNavigation() instanceof AleatoryNavigation) {
			// Adaptado de AleatoryNavigation.getNavigation
			node = getNavigation(scenarios, false);
		} else if (museum.getNavigation() instanceof GuidedNavigation) {
			// Adpatado de GuidedNavigation.getNavigation
			node = getNavigation(scenarios, false);
		} else {
			node = null;
		}
		setScenarios(museum.getScenarios());
		System.out.println(node.getScenario().getName());
		
		return node;
	}

	private Node getNavigation(List<Scenario> scenarios, boolean shuffle) {
		if (scenarios.isEmpty()) {
			return new Node();
		}

		Node node = new Node();
		int index = (shuffle) ? new Random(System.currentTimeMillis()).nextInt() % scenarios.size() : 0;
		node.setScenario(scenarios.get(index));
		if (scenarios.size() > 1) {
			List<Scenario> subScenarios = scenarios.subList(0, scenarios.size());
			subScenarios.remove(index);
			node.addNeighbor(getNavigation(subScenarios, shuffle));
		}

		return node;
	}

	private void setScenarios(List<Scenario> scenarios) {
		// Este método é uma gambiarra feita por causa da issue em https://github.com/guilhermejcgois/lpsmuseum/issues/4
		for (Scenario scenario : scenarios) {
			for (Scenario s : this.scenarios) {
				if (scenario.getId() == s.getId() && (scenario = null) == null) {
					break;
				}
			}
			if (scenario != null) {
				this.scenarios.add(scenario);
			}
		}
		setThemes();
	}

	private void setThemes() {
		for (Scenario scenario : scenarios) {
			Theme scenarioTheme = scenario.getTheme();
			boolean isNewTheme = true;
			for (Theme theme : themes) {
				if (theme.getId() == scenarioTheme.getId()) {
					isNewTheme = false;
					break;
				}
			}
			if (isNewTheme) {
				themes.add(scenarioTheme);
			}
		}
	}

	public List<Theme> getThemes() {
		return themes;
	}

}
