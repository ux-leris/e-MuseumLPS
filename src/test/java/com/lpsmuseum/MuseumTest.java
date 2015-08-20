package com.lpsmuseum;

import java.util.ArrayList;
import java.util.Calendar;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.lpsmuseum.behaviour.museum.navigation.GuidedNavigation;
import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.service.AnnotationService;
import com.lpsmuseum.service.MuseumService;
import com.lpsmuseum.service.builders.MuseologicalObjectBuilder;
import com.lpsmuseum.service.builders.MuseumBuilder;
import com.lpsmuseum.service.builders.ScenarioBuilder;

public class MuseumTest extends TestCase {
	
	Scenario oldScenario, newScenario, scenario;
	
	public MuseumTest( String testName )
    {
        super( testName );
    }
	
    public static Test suite()
    {
        return new TestSuite( MuseumTest.class );
    }
    
    /*
     * 	    Calendar date = Calendar.getInstance();
	    	date.add(Calendar.DAY_OF_MONTH, -1);
			Image img = new Image();
			img.setUrlAddress("http://www.test.com/");
			img = (Image)new MuseologicalObjectBuilder()
					.build("TestImage", date, img);
     */
    
    public void testBuilder()
    {
    	Museum museum;
		try {
			Image img = new Image();
			img.setUrlAddress("http://www.testmuseum.com/");
			img = (Image) new MuseologicalObjectBuilder()
				.build("TestMO", Calendar.getInstance(), img);
			
			Theme theme = new Theme();
			theme.setTitle("Tema teste 1");
			theme.setDescription("Tema teste de um cenário de testes.");
			scenario = new ScenarioBuilder()
						.withObject(img)
						.withTheme(theme)
						.build("ScenarioTest");
			museum = new MuseumBuilder()
							.withScenario(scenario)
							.withNavigation(new GuidedNavigation())
							.build("Museum1");
	    	assertNotNull(museum);
	    	assertTrue(museum.getScenarios().size() == 1);
	    	assertTrue(museum.getNavigation() instanceof GuidedNavigation);
	    	
	    	MuseumService service = new MuseumService();
	    	service.createMuseum(museum);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void testSort()
    {
    	Museum museum;
		try {
		    Calendar date = Calendar.getInstance();
		    date.add(Calendar.DAY_OF_MONTH, -1);
			MuseologicalObject img = new MuseologicalObjectBuilder()
				.build("ObjOld", date);
			
			Theme theme = new Theme();
			theme.setTitle("Tema teste 1");
			theme.setDescription("Tema teste de um cenário de testes.");
			
			oldScenario = new ScenarioBuilder()
							.withObject(img)
							.withTheme(theme)
							.build("Scenario2");
			MuseologicalObject obj = new MuseologicalObjectBuilder()
			.build("ObjNew", Calendar.getInstance());
			newScenario = new ScenarioBuilder()
						.withObject(obj)
						.withTheme(theme)
						.build("Scenario3");
			museum = new MuseumBuilder()
							.withScenario(newScenario)
							.withScenario(oldScenario)
							.build("Museum2");
			assertSame(oldScenario, museum.getScenarios().get(0));
			assertSame(newScenario, museum.getScenarios().get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void testAnnotations()
    {
		try {
	    	MuseologicalObject obj = new MuseologicalObjectBuilder()
						.build("Object", Calendar.getInstance());
	    	
	    	Theme theme = new Theme();
			theme.setTitle("Tema teste 1");
			theme.setDescription("Tema teste de um cenário de testes.");
			
			scenario = new ScenarioBuilder()
						.withObject(obj)
						.withTheme(theme)
						.build("Scenario");
			
			Annotation annotation = new Annotation();
			annotation.setTitle("Testing Annotation");
			annotation.setAuthor("LPS Museum");
			annotation.setContent("Testing annotation creation for Museum");
			
			Museum museum = new MuseumBuilder()
							.withScenario(scenario)
							.withAnnotation(annotation)
							.build("MuseumAnnotation");
			
			ArrayList<Annotation> an = new AnnotationService()
							.listByMuseum(museum.getId());
			assertFalse(an.isEmpty());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
