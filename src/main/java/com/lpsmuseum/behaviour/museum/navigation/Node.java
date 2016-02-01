package com.lpsmuseum.behaviour.museum.navigation;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dto.Scenario;
import java.io.Serializable;

/**
 * This class represents a <b>node</b> in the <u>graph navigation</u> of a 
 * museum.
 */
public class Node implements Serializable {
	
	/**
	 * This fields represents the actual <code>Scenario</code> in the 
	 * navigation.
	 */
	private Scenario scenario;
	
	/**
	 * This fields represents the neighbors node.
	 */
	private final List<Node> neighbors = new ArrayList<Node>();
	
	/**
	 * This fields represents the previous node in the path.
	 */
	private Node backtrack = null;

	/**
	 * Class constructor.
	 */
	public Node() {
	}
	
	/**
	 * Returns the actual scenario of the navigation.
	 * 
	 * @return the actual scenario of the navigation.
	 */
	public Scenario getScenario() {
		return scenario;
	}
	
	/**
	 * Sets the actual scenario of the navigation.
	 * 
	 * @param scenario the actual scenario of the navigation.
	 */
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	
	/**
	 * Returns the <code>List</code> of neighbors.
	 * 
	 * @return the <code>List</code> of neighbors.
	 */
	public List<Node> getNeighbors() {
		return neighbors;
	}
	
	/**
	 * Sets the <code>List</code> of neighbors.
	 * 
	 * @param neighbor the <code>List</code> of neighbors.
	 */
	public void addNeighbor(Node neighbor) {
		neighbors.add(neighbor);
	}
	
	/**
	 * Returns the <b>first neighbor</b> in the adjacent list.
	 * 
	 * @return the <b>first neighbor</b> in the adjacent list.
	 */
	public Node getNeighbor() {
		Node neighbor = neighbors.get(0);
		
		neighbor.backtrack = this;
		
		return neighbor;
	}
	
	/**
	 * Do the backtrack in the navigation path.
	 * 
	 * @return the previous node in the navigation path.
	 */
	public Node doBacktrack() {
		Node previous = this.backtrack;
		//this.backtrack = null;
		return previous;
	}

}
