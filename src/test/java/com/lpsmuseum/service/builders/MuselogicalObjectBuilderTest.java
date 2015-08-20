package com.lpsmuseum.service.builders;

import java.util.Calendar;

import com.lpsmuseum.dto.MuseologicalObject;

import junit.framework.TestCase;

public class MuselogicalObjectBuilderTest extends TestCase {

	public void testBuildStringCalendarMuseologicalObject() {
		MuseologicalObjectBuilder builder1 = new MuseologicalObjectBuilder();
		Calendar calendar = Calendar.getInstance();
		MuseologicalObject object1 = builder1.build("Object 1", calendar);
		MuseologicalObject object2 = builder1.build("Object 1", calendar);
		assertNotSame(object1, object2);
		
		MuseologicalObjectBuilder builder2 = new MuseologicalObjectBuilder();
		object2 = builder2.build("Object 1", calendar);
		assertNotSame(object1, object2);
	}

}
