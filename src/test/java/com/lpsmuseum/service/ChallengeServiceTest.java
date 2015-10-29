package com.lpsmuseum.service;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.dto.scenario.Answer;
import com.lpsmuseum.dto.scenario.ScenarioChallenge;
import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.entity.ChallengeDO;
import com.lpsmuseum.service.builders.ScenarioBuilder;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class ChallengeServiceTest {
	
	private ScenarioChallenge scenario;
	private Long challengeId = 0L;
	
	public ChallengeServiceTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
		scenario = null;
	}

	/**
	 * Test of createChallenge method, of class ChallengeService.
	 *
	@Test
	public void testCreateChallenge() throws Exception {
		System.out.println("createChallenge");
		Challenge challenge = new Challenge();
		challenge.setScenario(scenario);
		challenge.setDescription("Isto é um teste de criação de desafios, você acha que vai?");
		List<Answer> answers = new ArrayList<Answer>();
		Answer answer = new Answer();
		answer.setDescription("Deu bom");
		answers.add(answer);
		answer = new Answer();
		answer.setDescription("Deu ruim");
		answers.add(answer);
		answer = new Answer();
		answer.setDescription("Não sei dizer");
		answers.add(answer);
		challenge.setAnswers(answers);
		challenge.setCorrectAnswer(answer);
		ChallengeService instance = new ChallengeService();
		int sizeBefore = instance.listChallenges().size();
		scenario = (ScenarioChallenge) new ScenarioBuilder().withObject(new MuseologicalObjectService().listObjects().get(0)).withTheme(new ThemeService().listThemes().get(0)).withChallenge(challenge).build("Teste com Desafio");
		challenge.setScenario(scenario);
		instance.createChallenge(challenge);
		assertNotNull(scenario);
		List<Challenge> challenges = new ArrayList<Challenge>();
		assertNotEquals(0, challenges.size());
		int sizeAfter = challenges.size();
		assertNotEquals(0, sizeAfter);
		challengeId = challenges.get(sizeAfter - 1).getChallengeId();
		assertNotEquals(sizeBefore, sizeAfter);
	}*/

	/**
	 * Test of findById method, of class ChallengeService.
	 */
	@Test
	public void testFindById() throws Exception {
		System.out.println("findById");
		ChallengeService instance = new ChallengeService();
		Challenge result = instance.findById(11L);
		assertNotNull(result);
		System.out.println("Scenario: " + result.getScenario().getName());
		System.out.println("Question: " + result.getDescription());
		for (Answer answer : result.getAnswers())
			System.out.println("Answer: " + answer.getDescription());
	}

	/**
	 * Test of editChallenge method, of class ChallengeService.
	 *
	@Test
	public void testEditChallenge() throws Exception {
		System.out.println("editChallenge");
		Challenge challenge = null;
		ChallengeService instance = new ChallengeService();
		instance.editChallenge(challenge);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}*/

	/**
	 * Test of findChallenge method, of class ChallengeService.
	 *
	@Test
	public void testFindChallenge() throws Exception {
		System.out.println("findChallenge");
		Challenge challenge = null;
		ChallengeService instance = new ChallengeService();
		Challenge expResult = null;
		Challenge result = instance.findChallenge(challenge);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}*/

	/**
	 * Test of findEntity method, of class ChallengeService.
	 *
	@Test
	public void testFindEntity() throws Exception {
		System.out.println("findEntity");
		Challenge challenge = null;
		ChallengeService instance = new ChallengeService();
		ChallengeDO expResult = null;
		ChallengeDO result = instance.findEntity(challenge);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}*/

	/**
	 * Test of listChallenges method, of class ChallengeService.
	 */
	@Test
	public void testListChallenges() {
		System.out.println("listChallenges");
		ChallengeService instance = new ChallengeService();
		ArrayList<Challenge> result = instance.listChallenges();
		assertNotNull(result);
		assertNotEquals(0, result.size());
		for (Challenge challenge : result) {
			System.out.println("Scenario: " + challenge.getScenario().getName());
			System.out.println("Question: " + challenge.getDescription());
			for (Answer answer : challenge.getAnswers())
				System.out.println("Answer: " + answer.getDescription());
		}
	}

	/**
	 * Test of deleteChallenge method, of class ChallengeService.
	 *
	@Test
	public void testDeleteChallenge() throws Exception {
		System.out.println("deleteChallenge");
		Long id = challengeId;
		ChallengeService instance = new ChallengeService();
		instance.deleteChallenge(id);
		assertNull(instance.findById(id));
	}*/
	
}
