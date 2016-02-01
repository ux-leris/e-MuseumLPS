package com.lpsmuseum.behaviour.museum;

import java.util.ArrayList;

import com.lpsmuseum.dto.Annotation;

/**
 * This interface is a contract with all the behaviour of classes that works
 * with sharing of content of the museum.
 *
 */
public interface Share {
	
	/**
	 * Do the sharing of <code>annottions</code> on the web.
	 * 
	 * @param annotations the <code>List</code> of <code>Annotation</code> to 
	 * be shared on the web.
	 * @throws Exception the exceptions that could be raised.
	 */
	public void shareAnnotations(ArrayList<Annotation> annotations) throws Exception;
}
