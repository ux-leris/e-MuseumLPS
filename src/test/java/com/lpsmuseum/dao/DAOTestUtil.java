package com.lpsmuseum.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.lpsmuseum.behaviour.museum.navigation.AleatoryNavigation;
import com.lpsmuseum.behaviour.museum.navigation.GuidedNavigation;
import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.service.builders.MuseologicalObjectBuilder;
import com.lpsmuseum.service.builders.MuseumBuilder;
import com.lpsmuseum.service.builders.ScenarioBuilder;

public class DAOTestUtil {

	public static ArrayList<MuseologicalObject> generateMuseologicalObjects() {
		ArrayList<MuseologicalObject> objects = new ArrayList<MuseologicalObject>();

		MuseologicalObjectBuilder builder = new MuseologicalObjectBuilder();
		objects.add(builder.build("object one", Calendar.getInstance()));
		objects.add(builder.build("object two", Calendar.getInstance()));
		objects.add(builder.build("object three", Calendar.getInstance()));
		objects.add(builder.build("object four", Calendar.getInstance()));
		objects.add(builder.build("object five", Calendar.getInstance()));

		return objects;
	}

	public static ArrayList<Scenario> generateScenarios() throws Exception {
		ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
		
		Theme theme = new Theme();
		theme.setTitle("Tema de testes");
		theme.setDescription("Teste temático da LPS");
		
		List<MuseologicalObject> objects = DAOTestUtil.generateMuseologicalObjects();
		
		ScenarioBuilder builder = new ScenarioBuilder();
		
		int step = objects.size() / 3;
		for (int i = 0; i < objects.size(); i += step)
			builder.withObject(objects.get(i));
		scenarios.add(builder.withTheme(theme).build("scenario one"));
		
		builder.clear();
		for (int i = 1; i < objects.size(); i += step)
			builder.withObject(objects.get(i));
		scenarios.add(builder.withTheme(theme).build("scenario two"));
		
		builder.clear();
		for (int i = 2; i < objects.size(); i += step)
			builder.withObject(objects.get(i));
		scenarios.add(builder.withTheme(theme).build("scenario three"));
		
		return scenarios;
	}

	public static ArrayList<Museum> generateMuseuns() throws Exception {
		ArrayList<Museum> museums = new ArrayList<Museum>();
		
		List<Scenario> scenarios = generateScenarios();
		
		MuseumBuilder builder = new MuseumBuilder();
		
		int stepScenario = scenarios.size() / 2;
		for (int i = 0; i < scenarios.size() - 1; i += stepScenario)
			builder.withScenario(scenarios.get(i));
		museums.add(builder.withNavigation(new AleatoryNavigation()).build("Museum One"));
		
		builder.clear();
		for (int i = 1; i < scenarios.size() - 1; i += stepScenario)
			builder.withScenario(scenarios.get(i));
		museums.add(builder.withNavigation(new GuidedNavigation()).build("Museum Two"));
		
		return museums;
	}

	public static ArrayList<Annotation> generateAnnotations() {
		ArrayList<Annotation> annotations = new ArrayList<Annotation>();
		
		Annotation a1 = new Annotation();
		a1.setAuthor("Author one");
		a1.setContent("Content of first annotation");
		a1.setTitle("First Annotation");
		annotations.add(a1);
		
		Annotation a2 = new Annotation();
		a2.setAuthor("Author one");
		a2.setContent("Content of first annotation");
		a2.setTitle("First Annotation");
		annotations.add(a2);
		
		Annotation a3 = new Annotation();
		a3.setAuthor("Author one");
		a3.setContent("Content of first annotation");
		a3.setTitle("First Annotation");
		annotations.add(a3);
		
		return annotations;
	}

	public static ArrayList<Theme> generateThemes() {
		ArrayList<Theme> themes = new ArrayList<Theme>();
		
		Theme t1 = new Theme();
		t1.setTitle("Theme one");
		t1.setDescription("Theme description one");
		themes.add(t1);
		Theme t2 = new Theme();
		t2.setTitle("Theme two");
		t2.setDescription("Theme description two");
		themes.add(t2);
		Theme t3 = new Theme();
		t3.setTitle("Theme three");
		t3.setDescription("Theme description three");
		themes.add(t3);
		Theme t4 = new Theme();
		t4.setTitle("Theme four");
		t4.setDescription("Theme description four");
		themes.add(t4);
		Theme t5 = new Theme();
		t5.setTitle("Theme five");
		t5.setDescription("Theme description five");
		themes.add(t5);
		
		return themes;
	}
}
