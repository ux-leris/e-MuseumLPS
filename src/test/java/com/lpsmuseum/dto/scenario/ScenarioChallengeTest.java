package com.lpsmuseum.dto.scenario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.scenario.challenge.Question;
import com.lpsmuseum.dto.scenario.challenge.QuestionChallenge;
import com.lpsmuseum.dto.scenario.challenge.QuestionItem;
import com.lpsmuseum.service.builders.MuseologicalObjectBuilder;

import junit.framework.TestCase;

public class ScenarioChallengeTest extends TestCase {

	public void testScenarioChallenge() {
/*		QuestionChallenge challenge = new QuestionChallenge(1L);
		Question question = new Question(10L, "Onde fica a UFSCar Sorocaba?");
		question.addAnswer(new QuestionItem('a', "São Paulo"), true);
		question.addAnswer(new QuestionItem('b', "Pilar do Sul"), false);
		question.addAnswer(new QuestionItem('c', "Sorocaba"), true);
		challenge.addQuestion(question);
		question = new Question(11L, "Quantos anos para se formar como cientista da computação?");
		question.addAnswer(new QuestionItem('a', "3 anos"), false);
		question.addAnswer(new QuestionItem('b', "4 anos"), true);
		question.addAnswer(new QuestionItem('c', "5 anos"), false);
		challenge.addQuestion(question);
		
		List<MuseologicalObject> objects = new ArrayList<MuseologicalObject>();
		MuseologicalObjectBuilder objectBuilder = new MuseologicalObjectBuilder();
		objects.add(objectBuilder.clear().build("Object 1", Calendar.getInstance()));
		objects.add(objectBuilder.clear().build("Object 2", Calendar.getInstance()));
		objects.add(objectBuilder.clear().build("Object 3", Calendar.getInstance()));
		objects.add(objectBuilder.clear().build("Object 4", Calendar.getInstance()));
		objects.add(objectBuilder.clear().build("Object 5", Calendar.getInstance()));
		
		ScenarioChallenge scenarioChallenge = new ScenarioChallenge("Scenario Challenge Test", objects, challenge);
		
		Map<Long, Boolean> result = scenarioChallenge.getResult();
		for (Iterator<Long> iterator = result.keySet().iterator(); iterator.hasNext();)
			assertFalse(result.get(iterator.next()).booleanValue());
		
		scenarioChallenge.getChallenge().setAnswer(10L, 'c');

		result = scenarioChallenge.getResult();
		assertTrue(result.get(10L).booleanValue());
		assertFalse(result.get(11L).booleanValue());
		
		scenarioChallenge.getChallenge().setAnswer(11L, 'b');

		result = scenarioChallenge.getResult();
		for (Iterator<Long> iterator = result.keySet().iterator(); iterator.hasNext();)
			assertTrue(result.get(iterator.next()).booleanValue());
		*/
	}

}
