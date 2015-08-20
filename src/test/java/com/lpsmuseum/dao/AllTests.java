package com.lpsmuseum.dao;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(AnnotationDAOTest.class);
		suite.addTest(MuseologicalObjectoDAOTest.suite());
		suite.addTestSuite(MuseumDAOTest.class);
		suite.addTestSuite(ScenarioDAOTest.class);
		suite.addTestSuite(ThemeDAOTest.class);
		//$JUnit-END$
		return suite;
	}

}
