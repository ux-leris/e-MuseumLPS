package com.lpsmuseum.behaviour.object;

import com.lpsmuseum.dto.MuseologicalObject;
import java.util.List;

/**
 * This class represents an indexation of an owner museological object.
 * 
 * <p>
 * An owner museological object is the <code>MuseologicalObject</code> that has 
 * an instance of this <u>type</u> stored in your fields.
 * 
 * @see MuseologicalObject
 */
public class Indexation {

	/**
	 * This field represents the unique identification of the indexation.
	 */
	private int id;
	
	/**
	 * This field represents the <code>List</code> of words that index the 
	 * owner museoogical object.
	 */
	private List<String> words;

	/**
	 * Class constructor.
	 */
	public Indexation() {
	}

	/**
	 * What this method is for? Not a consensus of what is this.
	 */
	public void getIndex() {
	}

	/**
	 * Returns the <code>id</code> of this <code>Indexation</code> instance.
	 *
	 * @return the <code>id</code> of this <code>Indexation</code> instance.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the <code>id</code> of this <code>Indexation</code> instance.
	 *
	 * @param id the <code>id</code> of this <code>Indexation</code> instance.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the <code>List</code> of words of this <code>Indexation</code> 
	 * instance.
	 * 
	 * @return the <code>List</code> of words of this <code>Indexation</code> 
	 * instance.
	 */
	public List<String> getWords() {
		return words;
	}

	/**
	 * Sets the <code>List</code> of words of this <code>Indexation</code> 
	 * instance.
	 * 
	 * @param words the <code>List</code> of words of this <code>Indexation
	 * </code> instance.
	 */
	public void setWords(List<String> words) {
		this.words = words;
	}
}
