package com.lpsmuseum.behaviour.museum.navigation;

import java.util.List;
import java.util.Random;

import com.lpsmuseum.behaviour.museum.Navigation;
import com.lpsmuseum.dto.Scenario;

/**
 * This class gives an <b>aleatory navigation</b> to the owner museum.
 * 
 * <p>
 * The aleatory navigation is a randomly sort of scenarios, with the 
 * possibility to go to whatever scenario what you want, but you can't go back 
 * to a visited scenario.
 * 
 * @see Navigation
 */
public class AleatoryNavigation implements Navigation {

	/**
	 * Class constructor.
	 */
	public AleatoryNavigation() {
	}

	@Override
	public Node getNavigation(List<Scenario> scenarios) {
		if (scenarios.isEmpty())
			return new Node();
		
		Node node = new Node();
		int index = new Random(System.currentTimeMillis()).nextInt() % scenarios.size();
		node.setScenario(scenarios.get(index));
		if (scenarios.size() > 1) {
			List<Scenario> subScenarios = scenarios.subList(0, scenarios.size());
			subScenarios.remove(index);
			node.addNeighbor(getNavigation(subScenarios));
		}
		
		return node;
	}

}
