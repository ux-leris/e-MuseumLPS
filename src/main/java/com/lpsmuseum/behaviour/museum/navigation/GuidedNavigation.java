package com.lpsmuseum.behaviour.museum.navigation;

import java.util.List;

import com.lpsmuseum.behaviour.museum.Navigation;
import com.lpsmuseum.dto.Scenario;

/**
 * This class gives an <b>guided navigation</b> to the owner museum.
 * 
 * <p>
 * The guided navigation is a <b>path graph</b> of the <code>scenarios</code> 
 * of the owner museum.
 * 
 * @see Navigation
 */
public class GuidedNavigation implements Navigation {

	/**
	 * Class constructor.
	 */
	public GuidedNavigation() {
	}

	@Override
	public Node getNavigation(List<Scenario> scenarios) {
		if (scenarios.isEmpty())
			return new Node();
		
		Node node = new Node();
		node.setScenario(scenarios.get(0));
		if (scenarios.size() > 1) {
			List<Scenario> subScenarios = scenarios.subList(1, scenarios.size());
			node.addNeighbor(getNavigation(subScenarios));
		}
		
		return node;
	}

}
