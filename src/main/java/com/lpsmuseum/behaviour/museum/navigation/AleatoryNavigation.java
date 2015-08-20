package com.lpsmuseum.behaviour.museum.navigation;

import java.util.List;
import java.util.Random;

import com.lpsmuseum.behaviour.museum.Navigation;
import com.lpsmuseum.dto.Scenario;

public class AleatoryNavigation implements Navigation {

	public Node getNavigation(List<Scenario> scenarios) {
		//TODO: Grafo
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
