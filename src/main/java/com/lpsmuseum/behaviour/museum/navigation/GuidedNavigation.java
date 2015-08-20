package com.lpsmuseum.behaviour.museum.navigation;

import java.util.List;

import com.lpsmuseum.behaviour.museum.Navigation;
import com.lpsmuseum.dto.Scenario;

public class GuidedNavigation implements Navigation {

	public Node getNavigation(List<Scenario> scenarios) {
		//TODO: Lista (Fila) de cenários ordenados, retornar o primeiro.
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
