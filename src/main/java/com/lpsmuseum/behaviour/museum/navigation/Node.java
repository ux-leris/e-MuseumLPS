package com.lpsmuseum.behaviour.museum.navigation;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dto.Scenario;
import java.io.Serializable;

public class Node implements Serializable {
	private Scenario scenario;
	private List<Node> neighbors = new ArrayList<Node>();
	private Node backtrack = null;
	
	public Scenario getScenario() {
		return scenario;
	}
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	public List<Node> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(Node neighbor) {
		neighbors.add(neighbor);
	}
	
	public Node getNeighbor() {
		Node neighbor = neighbors.get(0);
		neighbor.backtrack = this;
		return neighbor;
	}
	
	public Node doBacktrack() {
		Node backtrack = this.backtrack;
		this.backtrack = null;
		return backtrack;
	}

}
