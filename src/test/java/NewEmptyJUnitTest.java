/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.scenario.ChallengePastPresent;
import com.lpsmuseum.service.ChallengePastPresentService;
import com.lpsmuseum.service.ImageService;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
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
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
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
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /**
     * Test of createChallengePastPresent method, of class ChallengePastPresentService.
     */
    public void testCreateChallengePastPresent() throws Exception {
        System.out.println("createChallengePastPresent");
        ChallengePastPresent challenge = new ChallengePastPresent();
        ImageService imageService = new ImageService();
        Image question = imageService.findById(2L);
        challenge.setImageQuestion(question);
        Image answer = imageService.findById(4L);
        challenge.setImageAnswer(answer);
        challenge.getImagesAlternativas().add(answer);
        Image wrong1 = imageService.findById(6L);
        challenge.getImagesAlternativas().add(wrong1);
        Image wrong2 = imageService.findById(8L);
        challenge.getImagesAlternativas().add(wrong2);
        ChallengePastPresentService instance = new ChallengePastPresentService();
        int preCount = instance.listChallenges().size();
        instance.createChallengePastPresent(challenge);
        if (instance.listChallenges().size() == preCount) fail(); else assertTrue(true);
    }
}
