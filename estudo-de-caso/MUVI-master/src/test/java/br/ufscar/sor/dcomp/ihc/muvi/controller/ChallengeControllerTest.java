package br.ufscar.sor.dcomp.ihc.muvi.controller;

import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.service.ChallengeService;
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
public class ChallengeControllerTest {
	
	private static ChallengeService service;
	private Challenge challenge;
	
	public ChallengeControllerTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		service = new ChallengeService();
	}
	
	@AfterClass
	public static void tearDownClass() {
		service = null;
	}
	
	@Before
	public void setUp() {
		List<Challenge> lc = service.listChallenges();
		
		challenge = lc.get((int) (System.currentTimeMillis() % lc.size()));
	}
	
	
	@After
	public void tearDown() {
		challenge = null;
	}

	/**
	 * Test of init method, of class ChallengeController.
	 */
	@org.junit.Test
	public void testInit() throws Exception {
		System.out.println("init");
		
		Long challenge = this.challenge.getChallengeId();
		Long correct = this.challenge.getAnswers().get(0).getId();//(int) (System.currentTimeMillis() % this.challenge.getAnswers().size())).getId();
		ChallengeController instance = new ChallengeController();
		instance.init(challenge, correct);

		assertNotNull(instance.getChallenge().getCorrectAnswer());
		if (instance.getChallenge().getCorrectAnswer() != null)
			assertEquals(correct, instance.getChallenge().getCorrectAnswer().getId());
	}

	/**
	 * Test of verify method, of class ChallengeController.
	 */
	@org.junit.Test
	public void testVerify() throws Exception {
		System.out.println("verify");
		
		Long answer = this.challenge.getAnswers().get((int) (System.currentTimeMillis() % this.challenge.getAnswers().size())).getId();
		Long correct = this.challenge.getAnswers().get((int) (System.currentTimeMillis() % this.challenge.getAnswers().size())).getId();
		ChallengeController instance = new ChallengeController();
		instance.init(this.challenge.getChallengeId(), correct);
		Boolean expResult = (answer == correct);
		Boolean result = instance.verify(answer);
		
		assertEquals(expResult, result);
	}
	
}
