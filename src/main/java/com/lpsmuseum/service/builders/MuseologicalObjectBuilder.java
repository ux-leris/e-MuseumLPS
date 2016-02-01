package com.lpsmuseum.service.builders;

import java.util.ArrayList;
import java.util.Calendar;

import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.service.AnnotationService;
import com.lpsmuseum.service.MuseologicalObjectService;
import java.util.List;

/**
 * This class provides a <b>builder</b> to creates <code>MuseologicalObject
 * </code>.
 *
 * @see MuseologicalObject
 */
public class MuseologicalObjectBuilder {

	/**
	 * This field represents the annotations to be related with the 
	 * <code>MuseologicalObject</code> instance.
	 */
	private final List<Annotation> annotations = new ArrayList<Annotation>();

	/**
	 * Builds a <code>MuseologicalObject</code> instance with actual state.
	 * 
	 * @param name the name of the museological object.
	 * @param date the <u>historial date</u> of the museological object.
	 * @return the builded <code>MuseologicalObject</code> instance.
	 */
	public MuseologicalObject build(String name, Calendar date) {
		return build(name, date, new MuseologicalObject());
	}

	/**
	 * Builds a <code>MuseologicalObject</code> (or child) instance with actual 
	 * state.
	 * 
	 * @param name the name of the museological object.
	 * @param date the <u>historial date</u> of the museological object.
	 * @param instance the type of returned object, can be 
	 * <code>MuseologicalObject</code> itself or a child class.
	 * @return the builded <code>MuseologicalObject</code> (or child) instance.
	 */
	public MuseologicalObject build(String name, Calendar date, MuseologicalObject instance) {
		MuseologicalObject obj = instance.createObject(name, date);
		MuseologicalObjectService svc = new MuseologicalObjectService();
		svc.createObject(obj);
		AnnotationService as = new AnnotationService();
		for (Annotation a : annotations) {
			a.setIdObject(obj.getId());
			as.createAnnotation(a);
		}
		return obj;
	}

	/**
	 * Builds an <code>Image</code> instance with actual state.
	 * 
	 * @param name the name of the image.
	 * @param date the <u>historial date</u> of the image.
	 * @param urlAddress the URL address of the image.
	 * @return the builded <code>Image</code> instance.
	 */
	public MuseologicalObject buildImage(String name, Calendar date, String urlAddress) {
		Image image = new Image();
		image.setUrlAddress(urlAddress);
		return build(name, date, image);
	}

	/**
	 * Adds a new annotation to be related to the <code>MuseologicalObject
	 * </code> instance to be builded.
	 * 
	 * @param annotation the <code>Annotation</code> to be added.
	 * @return this builder instance itself.
	 */
	public MuseologicalObjectBuilder withAnnotation(Annotation annotation) {
		annotations.add(annotation);
		return this;
	}

	/**
	 * Clears the state of this builder.
	 * 
	 * @return this builder instance itself.
	 */
	public MuseologicalObjectBuilder clear() {
		annotations.clear();

		return this;
	}
}
