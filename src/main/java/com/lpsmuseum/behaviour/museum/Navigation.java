package com.lpsmuseum.behaviour.museum;

import java.util.List;

import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;

/**
 * This interface is a contract with all the behaviour of classes that works 
 * with navigation inside a owner museum.
 * 
 * <p>
 * An owner museum is the <code>Museum</code> that has an instance of this 
 * <u>type</u> stored in your fields.
 *
 * @see Museum
 */
public interface Navigation {
	
	/**
	 * Returns the first node of the graph's navigation.
	 * 
	 * @param scenarios the scenarios of the owner museum.
	 * @return the first node of the graph's navigation.
	 */
	public Node getNavigation(List<Scenario> scenarios);
}
